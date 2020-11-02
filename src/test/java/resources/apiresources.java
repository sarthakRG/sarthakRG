package resources;

public enum apiresources {

	GetAllCharacter("people/"),
	GetAllPlanets("planets/");
	

	private String resource;
	
	apiresources(String res) {
		
		this.resource = res;
	}

	public String getresource()
	{
		return resource;
		
	}
	
}
