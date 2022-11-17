package mg.dpe.siigpe.ca.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mg.dpe.siigpe.ca.model.SiigpeRole;
import mg.dpe.siigpe.ca.model.SiigpeUser;
import mg.dpe.siigpe.ca.service.SiigpeRoleService;
import mg.dpe.siigpe.ca.service.SiigpeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    SiigpeRoleService roleService;

    //lister
    @GetMapping("/getRoles")
    public ResponseEntity<?> getRoleList() {
        return ResponseEntity.ok(roleService.findAll());
    }
    //ajouter

    @PostMapping("/addRole")
    public ResponseEntity<?> addRole(HttpServletRequest request, HttpServletResponse response) {
        SiigpeRole role = new SiigpeRole();
        String libelle = request.getParameter("roleLibelle");
        System.out.println("Libelle: " + libelle);
        role.setRoleLib(libelle);
        roleService.save(role);
        return ResponseEntity.ok(role);
    }
    
    //delete
    
     @DeleteMapping("/deleteRole")
    public ResponseEntity<SiigpeRole> deleteRole(HttpServletRequest request, HttpServletResponse response) {
        Short roleId = Short.valueOf(request.getParameter("roleId"));
        /*SiigpeRole role = roleService.findById(roleId).get();
        if (role != null){
            roleService.delete(role);
        }*/
        roleService.deleteById(roleId);
        return ResponseEntity.ok(null);
    }
    
    @GetMapping("/getRoleId/{id}")
    public ResponseEntity<SiigpeRole> getRoleId(@PathVariable(value = "id") short id ,HttpServletRequest request){
       //     Short roleId;
      //  roleId = Short.valueOf(request.getParameter(Short.parseShort(id)));
           return ResponseEntity.ok(roleService.findByRoleId(id));
    }
    
    //update
    /*@PutMapping("/Roles/{id}")
    public ResponseEntity<SiigpeRole> updateRole(@PathVariable Short id,@RequestBody SiigpeRole userDetails){
        SiigpeRole role = roleService.findById(id)
                .orElseThrow(() -> new ResourceNotException("RoleId n'existe pas :" + id));
        role.setRoleId(userDetails.getRoleId());
        role.setRoleLib(userDetails.getRoleLib());
        
        SiigpeRole updateRole = roleService.save(role);
        return ResponseEntity.ok(updateRole);
     }*/
    
    /*
    //ajouter
     @PostMapping("/Role")
    public SiigpeRole addRole(@RequestBody SiigpeRole  role){
        return service.save(role);
    }
    @GetMapping("/Role/{id}")
    public ResponseEntity<SiigpeRole> getRoleId(@PathVariable Short id){
        SiigpeRole role = service.findById(id)
                .orElseThrow(() -> new ResourceNotException("RoleId n'existe pas :" + id));
             return ResponseEntity.ok(role);
     }
    
    //update
    @PutMapping("/Role/{id}")
    public ResponseEntity<SiigpeRole> updateRole(@PathVariable Short id,@RequestBody SiigpeRole roleDetails){
        SiigpeRole role = service.findById(id)
                .orElseThrow(() -> new ResourceNotException("RoeleId n'existe pas :" + id));
        role.setRoleId(roleDetails.getRoleId());
        role.setRoleLib(roleDetails.getRoleLib());
        
        SiigpeRole updateRole = service.save(role);
        return ResponseEntity.ok(updateRole);
     }
    
    //delete
   @DeleteMapping("/Role/{id}")
   public ResponseEntity<Map<String , Boolean >> deleteUser (@PathVariable Short id){
       SiigpeRole role = service.findById(id)
                .orElseThrow(() -> new ResourceNotException("RoleId n'existe pas :" + id));
        service.delete(role);
        Map<String , Boolean> response = new HashMap<>();
        response.put("delete", Boolean.FALSE);
        return ResponseEntity.ok(response);
   }*/
}
