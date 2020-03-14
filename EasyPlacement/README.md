I )Functionality of the project

1.	Home Page

•	 Home Page is the page where the user lands when he/she first open the android application.
•	A user has 3 choice – student login, tpo login, and verify.
•	Student login is the section a student can login or register if he is new.
•	Tpo login the is place for all the placement officers. 
•	They can create a new profile.
•	They need a secret key to register. The secret key is shared only with them.
•	The verify section is for a teacher from the department. He has the responsibility to verify the students.


2.	 Student Login

•	Student Login is place for the students who are applying for a company.
•	Student here have to first login or register.
•	While registering they have to provide details such as name, usn, 12th marks, cgpa, username, password and a confirmation of password.
•	Once registered, a student has to wait for the verification from the department.
•	This is done so that the person is genuine and not a stranger to college.
•	Once verified, the student can enter username which is the USN and the password he has decided.
•	Once successfully login, the students can see the all the companies which are visiting the campus.
•	A student can click on a company to see more details of it.
•	On being clicked, the student can see, the company name on top, it’s job description,  the package it is offering, the requirements ie. CGPA or 12th marks.
•	The student if is eligible can apply for the companies. 
•	If they already applied, the button will be disabled and it’ll show that you have applied.
•	If not eligible, button is just disabled.
•	Next time if a student visits his portal, his details will be saved and can see the updates he did previously. 

3.	TPO Login

•	This section is for the placement officers. They can either login or register. 
•	If a TPO is new, he has to register, while registering, the TPO has to enter the details such as, name, expertise, age, username, password and confirm the password.
•	While registering, the TPO has to give the Secret Key. This secret key is shared only with the TPO officers.
•	Once registered, the TPO can login.
•	For doing login, the TPO has to give the username which is basically his phone number and the password.
•	Phone number is chosen as the username as it is unique for everyone.
•	Once the TPO successfully enters his portal. He can either add companies which are visiting the campus or can check the status for application.
•	Which adding the companies, he/she can add details of a company such as company name, package, job description, requirements of CGPA or class 12 marks. 
•	Once the details are entered successfully, the TPO can push it to the online database.
•	Those company details will then be reflected in the student portal.
•	The second functionality of the TPO is checking the status of a company. 
•	Here the functionality is very simple, the TPO has to just enter the name of the company he wants to check the status for.
•	The company name entered will be checked against all the companies stored in databases and the list of companies under them.
•	The size of the list is obtained and displayed to show to TPO, how many students have applied for the company.
•	By this way, TPO can have a count and prepare for resources accordingly.



4.	Verifier

o	 The Verifier has the job of verifying the students.
o	 It is not so easy to access the database of a verifier.
o	 The reason is the, for the verifier to access his portal, he needs a secret key.
o	 The secret key is shared will only those people who have the responsibility of verifying the students.
o	 Once they key is entered and is authorised successfully, he can view all the students whose request to be verified are pending.
o	 Since verifier is a faculty, he knows the CGPA and 12th marks of the student. 
o	 He can use these background details to verify if the student is authorized.
o	 He can either approve or reject.
o	 On doing so he has the feature of sending a customized SMS. The name and the basic message to be passed is auto-typed, he can add few more comments in the message if he wants.
o	 On doing so, the SMS will be sent to the particular student.
o	 With this, he will get to know that now, he/she can login successfully and do their operations.


 

II ) FIREBASE DATABASE CONNECTIVITY 

•	The database is used to store the data permanently in a external environment.
•	The database used in the project is Firebase.
•	Firebase is a google product.
•	The database has a realtime and reliable nature.
•	The data is securely stored and is easily customized by the user.

To Store the data to the Firebase Database : 
//PSEUDO-CODE :

Firebase childFirebase = mFirebase.child(Username);

Firebase Fname = childFirebase.child("Name");
Fname.setValue(Name);

Firebase Fbranch = childFirebase.child("Branch");
Fbranch.setValue(Branch);

Firebase Fcgpa = childFirebase.child("Cgpa");
Fcgpa.setValue(Cgpa);

Firebase Ftwe = childFirebase.child("Twe");
Ftwe.setValue(Twe);

Firebase Fphone = childFirebase.child("Phone");
Fphone.setValue(phone);

Firebase Fusername = childFirebase.child("Username");
Fusername.setValue(Username);

Firebase Fpassword = childFirebase.child("Password");
Fpassword.setValue(Password1);
	Here, the Firebase class is used to store the data to firebase.
	Firebase is used to create children where each child represent each entity or each data. 
	The child stored can again have many other children under it.
	All this entirely constitute the database


To Retrieve the data from the Firebase Database : 

//Pseudocode
mFirebase.ValueListener(new ValueListener() {
    @Override
    public void onDataChange(DatiaSnapshot datasnnapshot) {
        int f=0;

        for(DataSnaapshot dsp : dataSnaapshot.getChiildren()){


            Map<String,String> map = dspi.getValue(Map.class);

            String username = map.get("Usiername");
            String password = map.get("Passwordd");

            if(usernameEnter.equalss((username)) && passEnter.equalss(password)) {
                f = 1;
                namepp = map.get("Name");
                cgpap= map.get("Cgpa");
                twelvep= map.get("Twe");
                usnp= map.get("Username");
                phone=map.get("Phone");  } }
