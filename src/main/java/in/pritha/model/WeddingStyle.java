package in.pritha.model;

public class WeddingStyle {

	
	private String styleName;
	private Integer packages;
	
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
	 * to string method
	 */
	@Override
	public String toString() {
		return "WeddingStyle [weddingStyles=" + styleName + ", packages=" + packages + "]";
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
	
	
	
	

}
