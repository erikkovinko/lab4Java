package laba2;

import java.util.Objects;
import java.util.Scanner;


public class dog extends pet{
	private String breed;
	private int kidsBit;
	private dog(Builder builder){
		super(builder);
		this.breed=builder.breed;
		this.kidsBit=builder.kidsBit;
	}
	static class Builder extends pet.Builder{
		public Builder(String name, int age, boolean vacStatus, String gender,String breed,int kidsBit) {
			super(name, age, vacStatus, gender);
			this.breed=breed;
			this.kidsBit=kidsBit;
		}
		private String breed;
		private int kidsBit;
		public Builder breed(String breed) {
			this.breed=breed;
			return this;
		}
		public Builder kidsBit(int kidsBit) {
			this.kidsBit=kidsBit;
			return this;
		}
		public dog build() {
			dog newPet=new dog(this);
			validate(newPet);
			return newPet;
		}
		private void validate(dog dog) {
			if(dog.breed.length()>10) {
				throw new IllegalArgumentException("\nwe are not sure if name of breed "
						+ "can contain more than 10 letters\n");
			}
			if(dog.kidsBit<0) {
				throw new IllegalArgumentException("\nnumber of mice hunt by cat can't be less than zero!\n");
		}
			super.validate(dog);
		}
	}
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getKidsBit() {
		return kidsBit;
	}

	public void setKidsBit(int miceHunt) {
		this.kidsBit = miceHunt;
	}
	public void input() {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in); 
		System.out.print("Enter name of dog: ");  
		String name= sc.nextLine();  
		this.setName(name);
		System.out.print("Enter age of "+this.getName()+": ");  
		int age= sc.nextInt();  
		this.setAge(age);
		
		System.out.print("what gneder is it: ");  
		String gender= sc.nextLine();  
		this.setGender(gender);
		System.out.print("what breed is it: ");  
		String breed= sc.nextLine();  
		this.setBreed(breed);
		System.out.print("How many kids did it bit?(from zero to ...): ");  
		int kid= sc.nextInt();  
		this.setKidsBit(kid);
		System.out.print("Is it vaccinated? (0 or 1): ");  
		boolean vac= sc.nextBoolean();  
		this.setVacStatus(vac);
	}
	@Override
	public void animalSound() {
		System.out.print("\n!!!BARK BARk WOOOOF!!!\n");
	}
	@Override
	public String toString() {
		String hunterLvl="";
		if(kidsBit==0 && kidsBit<=10 ) {hunterLvl="small amount of kids";}
		if(kidsBit>11 && kidsBit<30 ) {hunterLvl="mid amount of kids";}
		if(kidsBit>30) {hunterLvl="nice, this dog is a serial killer";}
		String info="This dog's name is '"+this.getName()+"', its age is "+this.getAge()+
				" years.\n"+this.getName()+" bit "+ this.getKidsBit()+" kids, counclusion: "+hunterLvl+
				".\nGender: "+this.getGender()+"\nVaccination status: "+this.isVacStatus();
		return info;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(breed, kidsBit);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		dog other = (dog) obj;
		return Objects.equals(breed, other.breed) && kidsBit == other.kidsBit;
	}

}

