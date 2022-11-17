
package mg.dpe.siigpe.ca.service;

import java.util.List;
import java.util.Optional;
import mg.dpe.siigpe.ca.model.SiigpeRole;

public interface SiigpeRoleService {
    
    Optional<SiigpeRole> findById(short id);
    
    SiigpeRole findByRoleId(short id);
    
    SiigpeRole findByRoleLib(String RoleLib);
    
    List<SiigpeRole> findAll();
    
    SiigpeRole save(SiigpeRole role);

    void delete(SiigpeRole role);
    
    void deleteById(short id);

     List<SiigpeRole> findByRoleId(Short roles);
       
}
