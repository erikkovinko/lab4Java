package laba2;
import java.util.Scanner; 
import java.util.Objects;


public class cat extends pet {
	private String breed;
	private int miceHunt;
	private cat(Builder builder){
		super(builder);
		this.breed=builder.breed;
		this.miceHunt=builder.miceHunt;
	}
	static class Builder extends pet.Builder{
		public Builder(String name, int age, boolean vacStatus, String gender,String breed,int miceHunt) {
			super(name, age, vacStatus, gender);
			this.breed=breed;
			this.miceHunt=miceHunt;
		}
		private String breed;
		private int miceHunt;
		public Builder breed(String breed) {
			this.breed=breed;
			return this;
		}
		public Builder miceHunt(int miceHunt) {
			this.miceHunt=miceHunt;
			return this;
		}
		private void validate(cat cat) {
			if(cat.breed.length()>10) {
				throw new IllegalArgumentException("\nwe are not sure if name of breed "
						+ "can contain more than 10 letters\n");
			}
			if(cat.miceHunt<0) {
				throw new IllegalArgumentException("\nnumber of mice hunt by cat can't be less than zero!\n");
		}
			super.validate(cat);
		}
		public cat build() {
			cat newPet=new cat(this);
			validate(newPet);
			return newPet;
		}
	}
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getMiceHunt() {
		return miceHunt;
	}

	public void setMiceHunt(int miceHunt) {
		this.miceHunt = miceHunt;
	}
	public void input() {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("Enter name of cat: ");  
		String name= sc.nextLine();  
		this.setName(name);
		System.out.print("Enter age of "+this.getName()+": ");  
		int age= sc.nextInt();  
		this.setAge(age);
		System.out.print("Is it vaccinated? (true or false): ");  
		boolean vac= sc.nextBoolean();  
		this.setVacStatus(vac);
		System.out.print("what gender is it: "); 
		String gen= sc.nextLine();  
		this.setGender(gen);
		System.out.print("what breed is it: ");  
		String breed= sc.nextLine();  
		this.setBreed(breed);
		System.out.print("How many mice did it catch?(from zero to ...): ");  
		int mic= sc.nextInt();  
		this.setMiceHunt(mic);
		
	}
	@Override
	public void animalSound() {
		System.out.print("\n!MEOW!\n");
	}
	@Override
	public String toString() {
		String hunterLvl="";
		if(miceHunt==0 && miceHunt<=10 ) {hunterLvl="is weak fuck";}
		if(miceHunt>11 && miceHunt<30 ) {hunterLvl="is trying to be a hunter";}
		if(miceHunt>30) {hunterLvl="is damn good";}
		String info="This cat's name is '"+this.getName()+"', its age is "+this.getAge()+
				" years.\nThis cat hunt "+this.getMiceHunt()+" mices, so it "+hunterLvl+
				".\nGender: "+this.getGender()+"\nVaccination status: "+this.isVacStatus();
		return info;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(breed, miceHunt);
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
		cat other = (cat) obj;
		return Objects.equals(breed, other.breed) && miceHunt == other.miceHunt;
	}

}



