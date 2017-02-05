package tasks.first;

public class Provider {
	public static enum PROVIDER_NAME {
		VBB, DRIVENOW, CAR2GO, GOOGLE, NEXTBIKE, CALLABIKE, UNKOWN;
	}

	private String type;
	private PROVIDER_NAME typeEnum;
	private ProviderAttribute attributes;

	Provider(String name) {
		this.type = name;
	}

	@Override
	public String toString() {
		return "Provider [type=" + type + ", typeEnum=" + typeEnum + ", attributes=" + attributes + "]";
	}

	public PROVIDER_NAME getTypeEnum() {
		return typeEnum;
	}

	public void setTypeEnum(PROVIDER_NAME typeEnum) {
		this.typeEnum = typeEnum;
	}

	public ProviderAttribute getAttributes() {
		return attributes;
	}

	public void setAttributes(ProviderAttribute attributes) {
		this.attributes = attributes;
	}

	public void setType() {
		try {
			this.typeEnum = PROVIDER_NAME.valueOf(type.toUpperCase());
		} catch (Exception e) {
			this.typeEnum = PROVIDER_NAME.UNKOWN;
		}
	}

}
