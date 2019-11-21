package tetra3.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import tetra3.com.account.Account;
import tetra3.com.account.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping("/account/{role}/{username}/{password}")
	public Account createAccount(@ModelAttribute Account account) {
		return accountService.createNew(account);
	}
}
