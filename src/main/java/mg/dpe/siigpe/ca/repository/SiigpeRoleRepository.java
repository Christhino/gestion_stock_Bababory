package mg.dpe.siigpe.ca.repository;

import java.util.List;
import mg.dpe.siigpe.ca.model.SiigpeRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BasilisseN
 */
public interface SiigpeRoleRepository extends JpaRepository<SiigpeRole, Short>{
    
	SiigpeRole findByRoleId(short roleId);
        
        SiigpeRole findByRoleLib(String roleLib);
        
        List<SiigpeRole> findByRoleId(Short roleId);
}
