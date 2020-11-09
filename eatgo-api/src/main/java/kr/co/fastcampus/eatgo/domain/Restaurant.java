package kr.co.fastcampus.eatgo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<MenuItem>() ;

    public Restaurant( String name, String address ) {
        this.name = name;
        this.address = address;
    }

    public Restaurant( Long id, String name , String address ) {
        this.id =id;
        this.name =name;
        this.address =address;
    }

    //public void setId( long id ) {
    //    this.id = id;
    //}

    public String getInfomation() {
        return name +" in " + address ;
    }

    public void addMenuItem( MenuItem menuItem ) {
        menuItems.add(menuItem);
    }

    public void setMenuItems( List<MenuItem> menuItems ) {
        for(MenuItem menuItem: menuItems){
            addMenuItem(menuItem);
        }
    }

    public void updateInfomation( String name, String address ) {
        this.name = name;
        this.address = address;
    }
}
