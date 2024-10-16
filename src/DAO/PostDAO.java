package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BEAN.Post;

public class PostDAO extends DAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

	 // コンストラクタを追加
    public PostDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
 // getConnectionメソッドを修正
    public Connection getConnection() throws Exception {
    	// ドライバのロード
        Class.forName("org.h2.Driver");
    	Connection con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return con;
    }
	public List<Post> all() throws Exception {
		List<Post> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from post");
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Post p=new Post(0, null, null, null, null, 0);
			p.setPostId(rs.getInt("id"));
			p.setTitle(rs.getString("title"));
			p.setContent(rs.getString("content"));
			p.setName(rs.getString("name"));
			p.setPostDay(rs.getDate("post_day"));
			p.setCategoryId(rs.getInt("category_id"));

			list.add(p);
		}
		st.close();
		con.close();

		return list;
	}
}
