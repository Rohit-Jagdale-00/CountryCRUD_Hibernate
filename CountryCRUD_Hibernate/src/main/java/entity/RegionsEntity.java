package entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
 Create hibernate project to performed CRUD operation on Countries table and regions table using hibernate native api
 
 CREATE TABLE regions (
    region_id SERIAL PRIMARY KEY,
    region_name VARCHAR(25) DEFAULT NULL
 );
 */


@Entity
@Table(name="regions")
public class RegionsEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int region_id;

@Column(name ="region_name", length=25)
private String region_name;

public RegionsEntity() {}

public int getRegion_id() {
	return region_id;
}

public void setRegion_id(int region_id) {
	this.region_id = region_id;
}

public String getRegion_name() {
	return region_name;
}

public void setRegion_name(String region_name) {
	this.region_name = region_name;
}

}
