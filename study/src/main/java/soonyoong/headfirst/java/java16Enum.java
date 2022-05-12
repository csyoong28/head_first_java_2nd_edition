package soonyoong.headfirst.java;

public class java16Enum {
	public Members selectedBandMember;
	
	public static void main(String[] args) {
		java16Enum java16EnumInstance = new java16Enum();
		java16EnumInstance.selectedBandMember = Members.JERRY;
		System.out.println(java16EnumInstance.selectedBandMember);		
		Members phil = Members.PHIL;

		Members enumMember = Enum.valueOf(Members.class, "PHIL");
		System.out.println(enumMember);
	}
}
