package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.codejava.Departement.Departement;
import net.codejava.Departement.DepartementRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DepartementRepositoryTest {
	
	@Autowired
	private DepartementRepository repo;
	
	@Test
	public void testCreateDepartement() {
		Departement savedDepartement = repo.save(new Departement("DRC","Pierre", "Arcade"));
		
		assertThat(savedDepartement.getId()).isGreaterThan(0);
	}
	
}
