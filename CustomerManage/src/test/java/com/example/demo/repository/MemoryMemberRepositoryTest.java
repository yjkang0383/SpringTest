package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.example.demo.domain.Member;

public class MemoryMemberRepositoryTest {
	
	MemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach //로직이 끝날때 마지막으로 실행 됨
	public void afterEach() {
		repository.clearStore();
		
	}
	
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
		//System.out.print("result  " + (result == member));
		
		//Assertions.assertEquals(member, result); // member 값과 결과를 비교해서 결과를 알려줌
		//Assertions.assertEquals(member, null); // member 값과 결과를 비교해서 결과를 알려줌
		
		//assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		Member m1 = new Member();
		m1.setName("Spring");
		repository.save(m1);
		
		Member m2 = new Member();
		m2.setName("Spring2");
		repository.save(m2);
		
		Member result = repository.findByName("Spring").get();
		assertThat(result).isEqualTo(m1);
	}

	@Test
	public void findAll() {
		Member m1 = new Member();
		m1.setName("Spring1");
		repository.save(m1);
		
		Member m2 = new Member();
		m1.setName("Spring2");
		repository.save(m2);
		
		List<Member> result = repository.findAll();
		assertThat(result.size()).isEqualTo(2);
		
	}
}