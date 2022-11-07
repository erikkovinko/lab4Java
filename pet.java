package laba2;

import java.util.Objects;


public class pet {
	
	private String name;
	private int age;
	private boolean vacStatus;
	private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setName(String Name) {
		this.name=Name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isVacStatus() {
		return vacStatus;
	}
	public void setVacStatus(boolean vacStatus) {
		this.vacStatus = vacStatus;
	}
	public String getName() {
		return name;
	}
	public pet(Builder builder) {
		this.name=builder.name;
		this.age=builder.age;
		this.vacStatus=builder.vacStatus;
		this.gender=builder.gender;
	}
	public static class Builder{
		private String name;
		private int age;
		private boolean vacStatus;
		private String gender;
		public Builder(String name,int age,boolean vacStatus,String gender) {
			this.age=age;
			this.name=name;
			this.vacStatus=vacStatus;
			this.gender=gender;
		}
		public Builder age(int age) {
			this.age=age;
			return this;
		}
		public Builder name(String name) {
			this.name=name;
			return this;
		}
		public Builder vacStatus(boolean vacStatus) {
			this.vacStatus=vacStatus;
			return this;
		}
		public Builder gender(String gender) {
			this.gender=gender;
			return this;
		}
		public pet build() {
			pet newPet=new pet(this);
			validate(newPet);
			return newPet;
		}
		protected void validate(pet newPet) {
			if(newPet.name.length()>10) {
				throw new IllegalArgumentException("\nThere have to be less than 10 letters "
						+ "in name of pet!\n");
			}
			if(newPet.age>10 || newPet.age<0) {
				throw new IllegalArgumentException("\npet cant live to this age\n");
			}
			if(newPet.age>10 || newPet.age<0) {
				throw new IllegalArgumentException("\npet cant live to this age\n");
			}
			if(newPet.gender.length()>6) {
				throw new IllegalArgumentException("\nname of gender can't contain more than 6 letters\n");
			}
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name, vacStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pet other = (pet) obj;
		return age == other.age && Objects.equals(gender, other.gender) && Objects.equals(name, other.name)
				&& vacStatus == other.vacStatus;
	}
	public void print() {
		String not;
		if(this.isVacStatus()==false) {not="is not";}
		else {not="is";}
		System.out.printf("This pet's name is '"+this.getName()+"', it's age is: "+this.getAge()+" years and it "+not+" vaccinated");
	}
	public void animalSound() {
		System.out.print("Sample text");
	}
	public String toString() {
		return "Sample";
	}
	
}
