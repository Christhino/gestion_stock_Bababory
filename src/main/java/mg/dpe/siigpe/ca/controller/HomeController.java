package mg.dpe.siigpe.ca.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mg.dpe.siigpe.ca.model.LoginRequest;
import mg.dpe.siigpe.ca.service.SiigpeRoleService;
import mg.dpe.siigpe.ca.service.SiigpeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = {"Content-type"})
public class HomeController {
    
    @Autowired
    SiigpeUserService userService;

    @GetMapping("/listUser")
    public ResponseEntity<?> getUserList(){
        return ResponseEntity.ok(userService.findAll());
    }
    
    @Autowired
    SiigpeRoleService roleService;
    
    @GetMapping("/listRole")
    public ResponseEntity<?> getRoleList(){
        return ResponseEntity.ok(roleService.findAll());
    }
}    