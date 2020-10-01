import java.lang.Math;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;

public class Customer implements Comparable {
	@DomainConstraint(type = "String", mutable = false, optional = false, length = 50)
	private int id;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
	private String name;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
	private String phoneNumber;
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
	private String address;
	public Customer(@AttrRef("id")int id,@AttrRef("name") String name,@AttrRef("phoneNumber") String phoneNumber,@AttrRef("address") String address) {
		if(!validateName(name))
		{
			return;
		}
		if(!validatePhoneNumber(phoneNumber))
		{
			return;
		}
		if(!validateAddress(address))
		{
			return;
		}
		if(!validateId(id))
		{
			return;
		}
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;

	}
	/**
	 * @effects return <tt>phoneNumber</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	  /**
	   * @effects <pre>
	   *            if phoneNumber is valid
	   *              set this.phoneNumber = phoneNumber
	   *            else
	   *              throws NotPossibleException</pre>
	   */	
	@DOpt(type = OptType.Mutator)
	@AttrRef("phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
	    if (validatePhoneNumber(phoneNumber))
	        this.phoneNumber = phoneNumber;
	      else
	        System.err.println("Customer.setPhoneNumber: invalid phoneNumber: " + phoneNumber);
	}
	/**
	 * @effects return <tt>name</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("name")
	public String getName() {
		return name;
	}
	  /**
	   * @effects <pre>
	   *            if name is valid
	   *              set this.name = name
	   *            else
	   *              throws NotPossibleException</pre>
	   */
	@DOpt(type = OptType.Mutator)
	@AttrRef("name")
	public void setName(String name) {
	    if (validateName(name))
	        this.name = name;
	      else
	        System.err.println("Customer.setName: invalid name: " + name);
	}
	/**
	 * @effects return <tt>address</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("address")
	public String getAddress() {
		return address;
	}
	  /**
	   * @effects <pre>
	   *            if address is valid
	   *              set this.address = address
	   *            else
	   *              throws NotPossibleException</pre>
	   */
	@DOpt(type = OptType.Mutator)
	@AttrRef("address")
	public void setAddress(String address) {
	    if (validateAddress(address))
	        this.address = address;
	      else
	        System.err.println("Customer.setAddress: invalid address: " + address);
	}
	public int getId() {
		return id;
	}
	  /**
	   * @effects <pre>
	   *            if id is valid 
	   *              return true 
	   *            else 
	   *              return false</pre> 
	   */
	protected boolean validateId(int id)
	{
		return (id <= Math.pow(10, 9) && id >= 1);
	}
	  /**
	   * @effects <pre>
	   *            if name is valid 
	   *              return true 
	   *            else 
	   *              return false</pre> 
	   */
	private boolean validateName(String name)
	{
		return (name != null && name.length() > 0 && name.length() <= 50);
	}
	  /**
	   * @effects <pre>
	   *            if phoneNumber is valid 
	   *              return true 
	   *            else 
	   *              return false</pre> 
	   */
	private boolean validatePhoneNumber(String phoneNumber)
	{
		return (phoneNumber != null && phoneNumber.length() > 0 && phoneNumber.length() <= 10);
	}
	  /**
	   * @effects <pre>
	   *            if address is valid 
	   *              return true 
	   *            else 
	   *              return false</pre> 
	   */
	private boolean validateAddress(String address)
	{
		return (address != null && address.length() > 0 && address.length() <= 100);
	}
	

	@Override
	public int compareTo(Customer customer) {
		
		return this.name.compareTo(customer.getName());
	}


	

}
