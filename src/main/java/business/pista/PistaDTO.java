package business.pista;

import java.util.ArrayList;

import business.kart.KartDTO;
import business.kart.kartstat;

/**
 * A class that implements a track
 * @author Alfonso de la Torre
 * @author Abraham Córdoba
 * */


public class PistaDTO {
	/**
	 * The track name
	 */
	private String name;
	
	/**
	 * The id of the track
	 */
	private Integer id;
	
	/**
	 * The state of the track
	 */
	private Boolean state;
	/**
	 * Maximum number of karts
	 */
	private Integer maxKarts;
	/**
	 * Karts available to use
	 */
	private ArrayList<KartDTO> kartouse;

	
	/**
	 * The difficulty level of the track
	 */
	private diff difficulty;
	
	/**
	 * Empty (default) constructor
	 * */
	
	public PistaDTO() {
		this.kartouse=new ArrayList<KartDTO>(0);
	}
	
	/**
	 * Parameterized constructor
	 * @param name The name of the track
	 * @param state The state of the track
	 * @param maxKarts The maximum number of karts allowed in the track
	 * @param difficult The level of difficulty of the track
	 * */
	
	public PistaDTO(String name, Boolean state, Integer maxKarts,diff difficult){
		this.name=name;
		this.state=state;
		this.maxKarts=maxKarts;
		this.difficulty=difficult;
		this.kartouse=new ArrayList<KartDTO>(0);
	}
	
	public void setId(Integer ident) {
		this.id=ident;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setState(Boolean state) {
		this.state=state;
	}
	
	public Boolean getState() {
		return this.state;
	}
	
	public void setMaxkarts(Integer num) {
		this.maxKarts=num;
	}
	
	public Integer getMaxkarts() {
		return this.maxKarts;
	}
	
	public void setDifficulty(diff difficult) {
		this.difficulty=difficult;
	}
	
	public diff getDifficulty() {
		return this.difficulty;
	}
	
	public void setKartsinto(ArrayList<KartDTO> kartlist) {
		this.kartouse=kartlist;
	}
	
	public ArrayList<KartDTO> getKartsinto() {
		return this.kartouse;
	}
	
	public String toString(){
		if(this.getKartsinto().size()<=0) {
			return "La pista con id y nombre: "+this.getId()+", "+this.getName()+" con estado y dificultad: "+this.getState()+", "+this.getDifficulty()+" con capacidad maxima de "+this.getMaxkarts()+" esta vacia";
		}
		String cad="La pista "+this.getName()+" con estado y dificultad: "+this.getState()+", "+this.getDifficulty()+" con capacidad maxima de "+this.getMaxkarts()+ " y karts que se pueden usar que son los que tienen un id de:";
		for(int i=0;i<this.getKartsinto().size();i++) {
			cad=cad+" "+this.kartouse.get(i).getId();
		}
		return cad;
	}	
}
