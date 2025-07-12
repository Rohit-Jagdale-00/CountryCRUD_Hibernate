package service;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.HibernateUtil;
import entity.CountryEntity;


public class CountryService {


		public void saveCountry(CountryEntity country) {
			Transaction transcation=null;
			try(Session session =HibernateUtil.getSessionFactory().openSession();){
				transcation=session.beginTransaction();
				session.persist(country);
				transcation.commit();
			}catch(Exception e) {e.printStackTrace();}
		}
		
		public List<CountryEntity> getAllCountries(){
			try(Session session=HibernateUtil.getSessionFactory().openSession();){
				return session.createQuery("from CountryEntity",CountryEntity.class).list();
			}
		}
		
		public void updateCountry(String country_id, String country_name) {
			Transaction transcation=null;
			try(Session session =HibernateUtil.getSessionFactory().openSession();){
				transcation=session.beginTransaction();
				CountryEntity c= session.get(CountryEntity.class,country_id);
				if(c!=null) {
					c.setCountry_name(country_name);
					session.merge(c);
				}
				transcation.commit();
			}catch(Exception ee) {ee.printStackTrace();}
		}
		
		public void deleteCountry(String country_id) {
			Transaction transcation=null;
			try(Session session =HibernateUtil.getSessionFactory().openSession();){
				transcation=session.beginTransaction();
				CountryEntity con=session.get(CountryEntity.class,country_id);
				if(con!=null) {
					session.remove(con);
				}
				transcation.commit();
			}catch(Exception ee) {ee.printStackTrace();}
		}
		
		
	}//CountriesService
