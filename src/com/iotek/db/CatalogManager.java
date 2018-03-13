package com.iotek.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iotek.entity.CatalogBean;

public class CatalogManager {
	private CatalogBean catalogBean;

	public CatalogBean getCatalogBean() {
		return catalogBean;
	}

	public void setCatalogBean(CatalogBean catalogBean) {
		this.catalogBean = catalogBean;
	}

	public CatalogManager() {
		super();
	}

	public CatalogManager(CatalogBean catalogBean) {
		super();
		this.catalogBean = catalogBean;
	}
	
	public boolean saveCatalogBean(CatalogBean catalogBean){
		boolean result = false;
		
		String sql = "insert into d_t_catalog values(?,?,?,?,?)";
		PreparedStatement statement = null;
		ResultSet set = null;
		Connection conn = ConnectionFactory.createConnection();
		
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, catalogBean.getD_t_cataid());
			statement.setInt(2, catalogBean.getAuthorid());
			statement.setString(3, catalogBean.getCataname());
			statement.setString(4, catalogBean.getCatastate());
			statement.setString(5, catalogBean.getCatamemo());
			result = statement.executeUpdate()>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(!conn.isClosed()){
					conn.close();
				}
				/*if(!set.isClosed()){
					set.close();
				}
				if(!statement.isClosed()){
					statement.close();
				}*/
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return result;
	}
	
	@SuppressWarnings("null")
	public static List<CatalogBean> fetchCatalogs(int authorid){
		List<CatalogBean> catalogBeans = new ArrayList<CatalogBean>();
		
		String sql = "select * from d_t_catalog where authorid="+authorid+" order by cataid DESC";
		PreparedStatement statement = null;
		ResultSet set = null;
		Connection conn = ConnectionFactory.createConnection();
		
		try {
			System.out.println(sql);
			statement = conn.prepareStatement(sql);
			//conn.prepareStatement(sql);报java.lang.NullPointerException 找了好久
			set = statement.executeQuery();
			while(set.next()){
				catalogBeans.add(initCatalog(set));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(!conn.isClosed()){
					conn.close();
				}
				/*if(!set.isClosed()){
					set.close();
				}
				if(!statement.isClosed()){
					statement.close();
				}*/
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return catalogBeans;
	}

	private static CatalogBean initCatalog(ResultSet set) throws SQLException {
		CatalogBean cb = new CatalogBean();
		cb.setCataid(set.getInt(1));
		cb.setD_t_cataid(set.getInt(2));
		cb.setAuthorid(set.getInt(3));
		cb.setCataname(set.getString(4));
		cb.setCatastate(set.getString(5));
		cb.setCatamemo(set.getString(6));
		return cb;
	}
}
