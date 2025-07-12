package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.HibernateUtil;
import entity.RegionsEntity;

public class RegionService {
	
			public void saveRegions(RegionsEntity region) {
			 Transaction transcation=null;
				try(Session session =HibernateUtil.getSessionFactory().openSession();){
					transcation=session.beginTransaction();
					session.persist(region);
					transcation.commit();
				}catch(Exception e) {e.printStackTrace();}
			}
			
			public List<RegionsEntity> getAllRegions(){
				try(Session session=HibernateUtil.getSessionFactory().openSession();){
					return session.createQuery("from RegionsEntity",RegionsEntity.class).list();
				}
			}
			
			public void updateRegion(int region_id,String newregion_name) {
				Transaction transcation=null;
				try(Session session =HibernateUtil.getSessionFactory().openSession();){
					transcation=session.beginTransaction();
					RegionsEntity c= session.get(RegionsEntity.class,region_id);
					if(c!=null) {
						c.setRegion_name(newregion_name);
						session.merge(c);
					}
					transcation.commit();
				}catch(Exception ee) {ee.printStackTrace();}
			}
			
			public void deleteRegion(int id1) {
				Transaction transcation=null;
				try(Session session =HibernateUtil.getSessionFactory().openSession();){
					transcation=session.beginTransaction();
					RegionsEntity reg=session.get(RegionsEntity.class,id1);
					if(reg!=null) {
						session.remove(reg);
					}
					transcation.commit();
				}catch(Exception ee) {ee.printStackTrace();}
			}
			
			
		}//RegionService

