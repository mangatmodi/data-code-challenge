package tasks.first;

public class TaxiProperty extends Property {
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
			return "ClassPojo [phone = " + phone + ", name = " + name + "]";
		}
	}
}
