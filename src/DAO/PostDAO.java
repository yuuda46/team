package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BEAN.Post;

public class PostDAO extends DAO {
	public List<Post> all() throws Exception {
		List<Post> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from post");
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Post p=new Post();
			p.setPostId(rs.getString("id"));
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
