package my.project.controller;

import my.project.entity.Project;
import my.project.service.employee.entity.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mvc/project/")
public class ProjectController {

    @Autowired
    ProjectService projectService;

//    @Autowired
//    CreateEmployeePositionCommunicationService createEmployeePositionCommunicationService;
//
    @GetMapping(value = "/list")
    public String methodReturnDeveloperListPage(Model model) {
        List<Project> developerList = projectService.readAllProject();
        model.addAttribute("developersList", developerList);
        return "/project/projects/index";
    }
//
//    @GetMapping(value = "/delete")
//    public String deleteDeveloperById(@RequestParam(name = "deleteDeveloperIdParam") String deleteDeveloperIdParam) {
//        developerService.deleteDeveloperById(deleteDeveloperIdParam);
//        return "redirect:/mvc/developer/list";
//    }
//
//    @GetMapping("/edit")
//    public String editDeveloperPage(@RequestParam(name = "editDeveloperIdParam") String editDeveloperIdParam,
//                                    Model model) {
//        Developer developer = developerService.readDeveloperById(editDeveloperIdParam);
//        model.addAttribute("employee", developer);
//        return "/developer/edit/index";
//    }
//
//    @PostMapping("/edit")
//    public String developerEdit(@RequestPart(value = "image", required = false) MultipartFile updateEditEmployeePhotoParam,
//                                @RequestParam(name = "updateEmployeeIdParam") String updateEmployeeIdParam,
//                                @RequestParam(name = "updateEmployeeFirstNameParam") int updateEmployeeFirstNameParam,
//                                @RequestParam(name = "updateEmployeeSurnameParam") String updateEmployeeSurnameParam,
//                                @RequestParam(name = "updateEmployeeDateOfBornParam") String updateEmployeeDateOfBornParam,
//                                @RequestParam(name = "updateEmployeePositionParam") String updateEmployeePositionParam,
//                                Model model) {
//        try {
//            developerService.updateDeveloperById(updateEmployeeIdParam, updateEmployeeSurnameParam, updateEmployeeFirstNameParam);
//        } catch (EmployeeWebException e) {
//            List<String> errorList = e.getErrorList();
//            model.addAttribute("employeeSurnameParam", updateEmployeeSurnameParam);
//            model.addAttribute("employeeDateOfBornParam", updateEmployeeDateOfBornParam);
//            model.addAttribute("employeePositionParam", updateEmployeePositionParam);
//            model.addAttribute("messageList", errorList);
//            return "developer/edit/index";
//        }
//        return "redirect:/mvc/developers/list";
//    }
//
//    @GetMapping("/information")
//    public String returnAllDeveloperInformation(@RequestParam(name = "developerIdParam") String developerIdParam,
//                                                Model model) {
//        Developer developer = developerService.readDeveloperById(developerIdParam);
//        model.addAttribute("employee", developer);
//        model.addAttribute("project", developer);
//        return "/developer/information/index";
//    }
//
//    @GetMapping("/select")
//    public String returnSelectDeveloperList(@RequestParam(name = "selectEmployeeIdParam") String selectEmployeeIdParam,
//                                            @RequestParam("selectEmployeeFirstNameParam") String selectEmployeeFirstNameParam,
//                                            @RequestParam("selectEmployeeSurnameParam") String selectEmployeeSurnameParam,
//                                            @RequestParam("selectEmployeeDateOfBornParam") String selectEmployeeDateOfBornParam,
//                                            @RequestParam("selectEmployeePositionParam") String selectEmployeePositionParam,
//                                            Model model) {
////        List<Developer> developerList = developerService.readAllDeveloperByParameter(selectEmployeeIdParam, selectEmployeeFirstNameParam, selectEmployeeSurnameParam, selectEmployeeDateOfBornParam, selectEmployeePositionParam);
////        model.addAttribute("developersList", developerList);
//        model.addAttribute("employeeId", selectEmployeeIdParam);
//        model.addAttribute("employeeFirstName", selectEmployeeFirstNameParam);
//        model.addAttribute("employeeSurname", selectEmployeeSurnameParam);
//        model.addAttribute("employeeDateOfBorn", selectEmployeeDateOfBornParam);
//        model.addAttribute("employeePosition", selectEmployeePositionParam);
//        return "/employee/employees/index";
//    }
}
