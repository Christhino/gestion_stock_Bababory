package mg.dpe.siigpe.ca.repository;

import java.util.List;
import mg.dpe.siigpe.ca.model.SiigpeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiigpeUserRepository extends JpaRepository<SiigpeUser, Short>{
    
	SiigpeUser findByUserName(String username);

	Boolean existsByUserName(String username);
        
        List<SiigpeUser> findByUserId(Short userId);

    //public SiigpeUser save(SiigpeUser user);
}
