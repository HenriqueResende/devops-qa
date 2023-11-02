
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.modelo.Curso;
import com.projects.praticandoAPI.modelo.StatusCurso;

public class AlunoTest {

	@Test
	public void testAlunoSucesso(){
		//Asset
		List<Curso> CursosGratuitos = new ArrayList<Curso>();
		Curso curso = new Curso("Curso de bolo");
		Aluno aluno = new Aluno("Thiago José", curso);
		
		//Arrange
		CursosGratuitos.add(new Curso("Curso 1"));
		CursosGratuitos.add(new Curso("Curso 2"));
		CursosGratuitos.add(new Curso("Curso 3"));
		
		aluno.finalizarCurso("Curso de bolo", 8);
		
		//Action
		assertEquals(StatusCurso.SUCESSO, aluno.obterCursos("Curso de bolo", CursosGratuitos));
	}
	
	@Test
	public void testAlunoMedia(){
		//Asset
		List<Curso> CursosGratuitos = new ArrayList<Curso>();
		Curso curso = new Curso("Curso de torta");
		Aluno aluno = new Aluno("Henrique Resende", curso);
		
		//Arrange
		CursosGratuitos.add(new Curso("Curso 1"));
		CursosGratuitos.add(new Curso("Curso 2"));
		CursosGratuitos.add(new Curso("Curso 3"));
		
		aluno.finalizarCurso("Curso de torta", 7);
		
		//Action
		assertEquals(StatusCurso.NOTA_BAIXA, aluno.obterCursos("Curso de torta", CursosGratuitos));
	}
	
	@Test
	public void testAlunoCursoEmProgresso(){
		//Asset
		List<Curso> CursosGratuitos = new ArrayList<Curso>();
		Curso curso = new Curso("Mecânico industrical");
		Aluno aluno = new Aluno("Teo William", curso);
		
		//Arrange
		CursosGratuitos.add(new Curso("Curso 1"));
		CursosGratuitos.add(new Curso("Curso 2"));
		CursosGratuitos.add(new Curso("Curso 3"));
				
		//Action
		assertEquals(StatusCurso.EM_PROGRESSO, aluno.obterCursos("Mecânico industrical", CursosGratuitos));
	}
	
	@Test
	public void testNomeCursoErrado(){
		//Asset
		List<Curso> CursosGratuitos = new ArrayList<Curso>();
		Curso curso = new Curso("Mecânico industrical");
		Aluno aluno = new Aluno("Teo William", curso);
		
		//Arrange
		CursosGratuitos.add(new Curso("Curso 1"));
		CursosGratuitos.add(new Curso("Curso 2"));
		CursosGratuitos.add(new Curso("Curso 3"));
				
		//Action
		assertEquals(StatusCurso.CURSO_NAO_ENCONTRADO, aluno.obterCursos("Mecânico industrical 2", CursosGratuitos));
	}
}