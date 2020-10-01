import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;
public class HighEarner extends Customer  {

	private float income;
	private static final double MIN_INCOME = Math.pow(10,7);
	  // constructor methods
	  /**
	   * @effects <pre>
	   *            if id, name, phoneNumber, address, income are valid
	   *              Initialize this as HighEarner:<id,name,phoneNumber,address,income>
	   *            else
	   *              print error message
	   *          </pre>
	   */
	public HighEarner(@AttrRef("id")int id,@AttrRef("name") String name,@AttrRef("phoneNumber") String phoneNumber,
			@AttrRef("address") String address,@AttrRef("income") float income) {
		super(id, name, phoneNumber, address);
		if(!validateIncome(income))
			return;
		this.income = income;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @effects return <tt>income</tt>
	 */
	@DOpt(type = OptType.Observer)
	@AttrRef("income")
	public float getIncome() {
		return income;
	}
	  /**
	   * @effects <pre>
	   *            if income is valid
	   *              set this.income = income
	   *            else
	   *              throws NotPossibleException</pre>
	   */
	@DOpt(type = OptType.Mutator)
	@AttrRef("income")
	public void setIncome(float income) {
	    if (validateIncome(income))
	        this.income = income;
	      else
	        System.err.println("HighEarner.setIncome: invalid income: " + income);
		
	}
	  /**
	   * @effects <pre>
	   *            if w is valid 
	   *              return true 
	   *            else 
	   *              return false</pre>
	   */

	@DomainConstraint(type="Float",min= MIN_INCOME,optional=false)
	private boolean validateIncome(float income)
	{
		return income >= MIN_INCOME;
	}
	protected boolean validateId(int id)
	{
		return (id <= Math.pow(10, 9) && id >= Math.pow(10, 7));
	}



	

}
