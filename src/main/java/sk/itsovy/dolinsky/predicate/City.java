package sk.itsovy.dolinsky.predicate;

/**
 * @author Martin Dolinsky
 */
public class City {
	private String name;
	private String district;
	private String code;
	private int population;


	public City() {
	}

	public City(String name, String district, String code, int population) {
		this.name = name;
		this.district = district;
		this.code = code;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City{" +
				"name='" + name + '\'' +
				", district='" + district + '\'' +
				", code='" + code + '\'' +
				", population=" + population +
				'}';
	}
}
