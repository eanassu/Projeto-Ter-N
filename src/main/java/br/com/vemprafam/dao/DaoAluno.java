package br.com.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vemprafam.pojo.Aluno;

public class DaoAluno {
	
	private Connection conn;

	public DaoAluno() {
		super();
		try {
			conn = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/",
					"SA","");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Aluno> getAlunos() {
		List<Aluno> result = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT ra,nome,renda,dataNascimento,email from Alunos");
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				result.add(new Aluno(rs.getInt(1),rs.getString(2),
						rs.getDouble(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public void inserirAluno(Aluno aluno) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO alunos values(?,?,?,?,?)");
			pstmt.setInt(1, aluno.getRa());
			pstmt.setString(2, aluno.getNome());
			pstmt.setDouble(3, aluno.getRenda());
			pstmt.setDate(4, 
				new java.sql.Date(aluno.getDataNascimento().getTime()));
			pstmt.setString(5, aluno.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public void excluirPeloRa( int ra ) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM alunos WHERE ra=?");
			pstmt.setInt(1, ra);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public Aluno buscarPeloRa( int ra ) {
		Aluno result = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT ra,nome,renda,dataNascimento,email from Alunos "
					+ "WHERE ra = ?");
			pstmt.setInt(1, ra);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				 result = new Aluno(rs.getInt(1),rs.getString(2),
						rs.getDouble(3),rs.getDate(4),rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public void alterarAluno(Aluno aluno) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
				"UPDATE alunos "
				+ "SET nome=?, renda=?, dataNascimento=?, email=? "
				+ "WHERE ra=?");
			pstmt.setString(1, aluno.getNome());
			pstmt.setDouble(2, aluno.getRenda());
			pstmt.setDate(3, 
				new java.sql.Date(aluno.getDataNascimento().getTime()));
			pstmt.setString(4, aluno.getEmail());
			pstmt.setInt(5, aluno.getRa());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
}
