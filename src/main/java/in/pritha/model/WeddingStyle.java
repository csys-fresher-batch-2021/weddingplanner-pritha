package in.pritha.model;

public class WeddingStyle {

	
	private String styleName;
	private Integer packages;
	private String weddingLocation;
	private Integer locationPackages;
	private String foodType;
	private Integer foodPackages;
	private String guestCount;
	private Integer guestPackages;
	private String decorType;
	private Integer decorPackages;
	private String imageURL;
	private String image;
	
	
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * This method return the package
	 * @return
	 */
	public Integer getPackages() {
		return packages;
	}
	
	/**
	 * This method return the stylename
	 * @return
	 */
	public String getWeddingStyles() {
		return styleName;
	}
	/**
	 * This method return the stylename
	 * @return
	 */
	public String getWeddingLocations() {
		return weddingLocation;
	}
	/**
	 * This method return the stylename
	 * @return
	 */
	public Integer getLocationPackages() {
		return locationPackages;
	}
	/**
	 * This method return the stylename
	 * @return
	 */
	public String getFoodType() {
		return foodType;
	}
	/**
	 * This method return the stylename
	 * @return
	 */
	public Integer getFoodPackages() {
		return foodPackages;
	}
	/**
	 * This method return the stylename
	 * @return
	 */
	public String getguestCount() {
		return guestCount;
	}
	/**
	 * This method return the stylename
	 * @return
	 */
	public Integer guestPackages() {
		return guestPackages;
	}
	/**
	 * This method return the stylename
	 * @return
	 */
	public String getdecorType() {
		return decorType;
	}
	/**
	 * This method return the stylename
	 * @return
	 */
	public Integer decorPackages() {
		return decorPackages;
	}
	
	
	public WeddingStyle(String styleName, String weddingLocation, String foodType, String guestCount,
			String decorType) {
		super();
		this.styleName = styleName;
		this.weddingLocation = weddingLocation;
		this.foodType = foodType;
		this.guestCount = guestCount;
		this.decorType = decorType;
	}

	/**
	 * to string method
	 */
	@Override
	public String toString() {
		return "WeddingStyle [weddingStyles=" + styleName + ", packages=" + packages + "]";
	}
	
	public WeddingStyle(String styleName) {
		super();
		this.styleName = styleName;
	}

	/**
	 * Private constructor to avoid object creation 
	 * @param weddingStyles
	 * @param packages
	 */
	public WeddingStyle(String weddingStyles, Integer packages) {
		super(); 
		this.styleName = weddingStyles;
		this.packages = packages;
	}

	public WeddingStyle(String weddingStyle, int packages, String image) {
		super();
		this.styleName = weddingStyle;
		this.packages = packages;
		this.image = image;
		
		
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
	
	
	

}
