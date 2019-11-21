package tetra3.com.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRespository extends JpaRepository<Account, Integer> {

	Account findByUsername(String username);
	

}
