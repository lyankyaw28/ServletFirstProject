package pagination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaginationDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/servletcrud?" + "user=root&password=root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static List<PaginationEntity> getRecords(int start, int total) {
		List<PaginationEntity> list = new ArrayList<PaginationEntity>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp limit " + (start - 1) + "," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PaginationEntity e = new PaginationEntity();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
