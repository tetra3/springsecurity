package tetra3.com;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import tetra3.com.account.Account;
import tetra3.com.account.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

	@Autowired
	 MockMvc mockMvc; 
	
	@Autowired
	AccountService accountService;
	
//	@Test
//	public void index_anonymous() throws Exception {
//		mockMvc.perform(get("/").with(anonymous()))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
	
//	@Test
//	@WithAnonymousUser
//	public void index_anonymousAnnotation() throws Exception {
//		mockMvc.perform(get("/"))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
	
	
	// 이미 jaehyun, USER 라는 유저가 로그인해 있다고 가정하고 / 에 들어갔을때 응답을 테스트 하는 것이다
	
//	@Test
//	public void index_user() throws Exception {
//		mockMvc.perform(get("/").with(user("jaehyun").roles("USER")))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
	
//	@Test
//	@WithUser
//	public void index_userAnnotation() throws Exception {
//		mockMvc.perform(get("/").with(user("jaehyun").roles("USER")))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
	
//	@Test
//	public void index_admin() throws Exception {
//		mockMvc.perform(get("/admin").with(user("keesun").roles("USER")))
//				.andDo(print())
//				.andExpect(status().isForbidden());
//	}
	
//	@Test
//	@WithMockUser(username ="keesun", roles = "ADMIN")
//	public void index_adminAnnotation() throws Exception {
//		mockMvc.perform(get("/admin").with(user("keesun").roles("USER")))
//				.andDo(print())
//				.andExpect(status().isForbidden());
//	}
	
	
	@Test
	public void login() throws Exception {
		Account user = createJaehyun();
		mockMvc.perform(formLogin().user(user.getUsername()).password("123"))
			.andExpect(authenticated());
		
		
	}

	private Account createJaehyun() {
		Account account = new Account();
		account.setUsername("jaehyun");
		account.setPassword("123");
		account.setRole("USER");
		return accountService.createNew(account);
	}

}
