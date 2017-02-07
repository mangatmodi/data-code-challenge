package tasks.first;

public class Provider {
	private static int prevProvider = 0;
	private String type;
	private ProviderAttribute attributes;

	Provider(String name) {
		this.type = name;
	}

	public void cleanData() {
		if (type == null) {
			type = "";
		}
		attributes.cleanData();
	}

	public void pPrint() {
		prevProvider++;
		cleanData();
		System.out.println("ProviderRoute\u0001" + prevProvider + '\u0001' + type + '\u0001' + attributes);
	}

	@Override
	public String toString() {
		return "ProviderRoute type=" + type + ", , attributes=" + attributes + "]";
	}

	public ProviderAttribute getAttributes() {
		return attributes;
	}

	public void setAttributes(ProviderAttribute attributes) {
		this.attributes = attributes;
	}

}
