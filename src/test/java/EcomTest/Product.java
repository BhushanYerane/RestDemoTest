package EcomTest;

public class Product {
    private String productName;
    private String productAddedBy;
    private String productCategory;
    private String productSubCategory;
    private String productPrice;
    private String productDescription;
    private String productFor;

    // Constructors
    public Product(String productName, String productAddedBy, String productCategory, String productSubCategory, String productPrice, String productDescription, String productFor) {
        this.productName = productName;
        this.productAddedBy = productAddedBy;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productFor = productFor;
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductAddedBy() {
		return productAddedBy;
	}

	public void setProductAddedBy(String productAddedBy) {
		this.productAddedBy = productAddedBy;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductFor() {
		return productFor;
	}

	public void setProductFor(String productFor) {
		this.productFor = productFor;
	}   
}
