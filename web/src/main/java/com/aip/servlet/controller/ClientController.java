package com.aip.servlet.controller;

import com.aip.dao.dto.ClientAllDto;
import com.aip.dao.model.Client;
import com.aip.dao.model.Officer;
import com.aip.service.dto.ClientServiceDto;
import com.aip.service.dto.OfficerServiceDto;
import com.aip.service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Controller
// @RequestMapping("/aip-client") // нужно будет вводить URL localhost:8080/aip-client/client
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/findbyallclient")
    public String getFindByAllClient(Model model, @RequestParam("idPage") String param){

        Integer idButton;           // ид кнопки
        Integer countTableRows;     // количетсво строчек в таблице
        Integer countButtonByPage;  // вычисление сколько кнопок навигации будет на странице

        Integer nButtonFOR;         // для цикла т.к в цикле начало нумерации с 0
        Integer countRowsByPage = 20;   // сколько строк на одной странице

        if (param == null || param.isEmpty()) {
            idButton = 0;
        }else {
            idButton = Integer.parseInt(param)-1;
        }

        countTableRows = clientService.findByCountRows();           // возвращает кол-во строк в таблице
        countButtonByPage = countTableRows / countRowsByPage + 1;       // рассчит кол-во кнопок


        nButtonFOR = countButtonByPage + 1; // потому что цикл в for начинается с "0"
        ArrayList<Integer> arrIntButton = new ArrayList<Integer>();
        for (int i = 1; i < nButtonFOR; i++) {
            arrIntButton.add(i);
        }

        for (int iii:arrIntButton) {
            System.out.println(iii);
        }
        //========================================
        // List<Client> findAllBy = clientService.findAllBy(idButton, countRowsByPage);

        List<ClientAllDto> findAllBy = clientService.findAllByClientOpenDtoAnalytic(idButton, countRowsByPage);
        model.addAttribute("findAllBy", findAllBy);
        model.addAttribute("arrIntButton", arrIntButton);
        return "home";
    }

    /// DTO ////
    // не понятно что я здесь хотел сделать!?
    @GetMapping("/findbyallclientdto")
    public String getFindByAllClientDto(Model model){
        List<Client> findAllByDto = clientService.findAllByQueryMethod();
        for (Client clientDto:findAllByDto) {
            System.out.println(clientDto.getId()+" "+clientDto.getShortName()+" "+clientDto.getName());
        }
        model.addAttribute("findAllByDto", findAllByDto);
        return "home";
    }

    @GetMapping("/findbyclient")
    public String getFindByClientId(Model model, @RequestParam("id") String param){
        // Optional<Client> findById = clientService.findById(1L);
        long id = Long.parseLong(param);
        Client findById = clientService.findById(id);
        model.addAttribute("findById", findById);
        return "home";
    }

    @GetMapping("/findbyclientnamepage")
    public String getFindByClientNamePage(Model model){
        return "findbyclientnamepage";
    }

    @GetMapping("/findbyclientname")
    public String getFindByClientName(Model model, @RequestParam("clientname") String clientName){
        List<Client> findAllBy = clientService.findByName(clientName);
        model.addAttribute("findAllBy", findAllBy);
        return "home";
    }


    @GetMapping("/clientaddpage")
    public String getAddByClientPage(Model model){
        return "clientaddpage";
    }

    @PostMapping("/clientadd")
    public String getAddByClient(Model model
            , @RequestParam("clientNumber") String clientNumber
            , @RequestParam("name") String name
            , @RequestParam("shortName") String shortName
            , @RequestParam("analyticType") String analyticType
            , @RequestParam("analyticCode") String analyticCode
            , @RequestParam("dateOpen") String dateOpen
            , @RequestParam("dateClose") String dateClose
            , @RequestParam("unp") String unp
            , @RequestParam("account") String account
            , @RequestParam("legalCity") String legalCity
            , @RequestParam("legalStreet") String legalStreet
            , @RequestParam("legalHouse") String legalHouse
            , @RequestParam("territoryCity") String territoryCity
            , @RequestParam("territoryStreet") String territoryStreet
            , @RequestParam("territoryHouse") String territoryHouse
            , @RequestParam("designationType") String designationType
            , @RequestParam("designationCode") String designationCode
            , @RequestParam("countPerson") String countPerson
            , @RequestParam("status") String status
            , @RequestParam("officer") String officer) {
        ClientServiceDto clientServiceDto = new ClientServiceDto();
        clientServiceDto.setClientNumber(clientNumber);
        clientServiceDto.setName(name);
        clientServiceDto.setShortName(shortName);
        clientServiceDto.setAnalyticType(analyticType);
        clientServiceDto.setAnalyticCode(analyticCode);
        clientServiceDto.setDateOpen(dateOpen);
        clientServiceDto.setDateClose(dateClose);
        clientServiceDto.setUnp(unp);
        clientServiceDto.setAccount(account);
        clientServiceDto.setLegalCity(legalCity);
        clientServiceDto.setLegalStreet(legalStreet);
        clientServiceDto.setLegalHouse(legalHouse);
        clientServiceDto.setTerritoryCity(territoryCity);
        clientServiceDto.setTerritoryStreet(territoryStreet);
        clientServiceDto.setTerritoryHouse(territoryHouse);
        clientServiceDto.setDesignationType(designationType);
        clientServiceDto.setDesignationCode(designationCode);
        clientServiceDto.setCountPerson(countPerson);
        clientServiceDto.setStatus(status);
        clientServiceDto.setOfficer(officer);

        Client clientadd = clientService.addByClientNew(clientServiceDto);
        model.addAttribute("clientadd", clientadd);
        return "home";
    }

    @PostMapping("/updatebyclient")
    public String getUpdateByClient(Model model){
        return "client";
    }

    @PostMapping("/closebyclient")
    public String getCloseByClient(Model model){
        return "client";
    }


    //===================================================///

    // если откоментить в model/Client аннотацию @Builder то можно откоментить и здесь!!
//    @GetMapping("/client")
//    public String getClientPage(Model model){
//        Client client = Client.builder()
//                .clientNumber("200006")
//                .name("ООО ИНКОФУД")
//                .shortName("ООО ИНКОФУД")
//                .analyticType(1L)
//                .analyticCode(1L)
//                .dateOpen(Instant.now())
//                .dateClose(Instant.now())
//                .unp(200187973)
//                .account("BY67BSBB301220000600103400000")
//                .designationType(2)
//                .designationCode(1)
//                .countPerson(23345)
//                .status(Status.OPEN)
//                .legalCity("Витебск").legalStreet("кросноармейская").legalHouse("31Д")
//                .territoryCity("Витебск").territoryStreet("кросноармейская").territoryHouse("31Д")
//                .build();
//        model.addAttribute("clients", client);
//        return "client";
//    }

    @GetMapping("/clientall")
    public String getClientAll(Model model){
        List<Client> clientAll = clientService.findAllBy(0,10);
//        for (Client client:clientAll) {
//            System.out.println(client.getName());
//        }
        model.addAttribute("clientall", clientAll);
        return "client";
    }

    @PostMapping("/clientsave")
    public String aaveClient(List<Client> clientAll){
        System.out.println();
        for (Client client:clientAll) {
            System.out.println(client.getName());
        }
        // return "redirect:/clientall";
        return "client";
    }

    @PostMapping("/clientsavetext")
    public String aaveClientText(Model model, @RequestParam("uname") String param) {
        System.out.println(param);
        // return "redirect:/clientall";
        return "client";
    }


    @GetMapping("/findClientByFilter")
    public String findClientByFilter(Model model, @RequestParam("relationtype1") String relationtype1, @RequestParam("relationtype2") String relationtype2, @RequestParam("relationtype3") String relationtype3, @RequestParam("relationtype4") String relationtype4){

        Long relationtype1Long = Long.parseLong(relationtype1);
        Long relationtype2Long = Long.parseLong(relationtype2);
        Long relationtype3Long = Long.parseLong(relationtype3);
        Long relationtype4Long = Long.parseLong(relationtype4);

        List<ClientAllDto> findAllBy = clientService.findAllByClientOpenDtoAnalyticFilter(relationtype1Long, relationtype2Long, relationtype3Long, relationtype4Long);

        model.addAttribute("findAllBy", findAllBy);

        return "home";
    }

}
