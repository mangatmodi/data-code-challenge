package tasks.first.properties;

public class TaxiProperty extends Property {
	private int companyId;
	private Companies[] companies;

	public Companies[] getCompanies() {
		return companies;
	}

	public void setCompanies(Companies[] companies) {
		this.companies = companies;
	}

	@Override
	public String toString() {
		return "ClassPojo [companies = " + companies + "]";
	}

	static public class Companies {
		private String phone;

		private String name;

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return phone + '\u0001' + name;
		}

		public void cleanData() {
			if (phone == null) {
				phone = "";
			}
			if (name == null) {
				name = "";
			}
		}
	}

	@Override
	public void cleanData() {
		for (Companies c : companies) {
			c.cleanData();
		}

	}

	@Override
	public void pPrint(int routeId) {
		for (Companies c : companies) {
			companyId++;
			System.out.println("TaxiRoute\u0001" + companyId + "" + '\u0001' + routeId);
			System.out.println("TaxiProperty\u0001" + companyId + "" + '\u0001' + c);
		}

	}
}
