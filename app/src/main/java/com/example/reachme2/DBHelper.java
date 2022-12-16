package com.example.reachme2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "rm84.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        /*DB.execSQL(" CREATE TABLE workExperiencee(_id INTEGER PRIMARY KEY ,jobTitle TEXT , companyName TEXT , specialization TEXT ,companyIndusty TEXT,startDate TEXT , endDAte TEXT ," +
                "iCurrentlyWorkHere INTEGER , jobDescription TEXT )");*/
        DB.execSQL(" CREATE TABLE workExperiencee(_id INTEGER PRIMARY KEY ,jobTitle TEXT , companyName TEXT, specialization TEXT,companyIndusty TEXT,positionLevel TEXT,startDate TEXT , endDAte TEXT , iCurrentlyWorkHere INTEGER ,  jobDescription TEXT , email TEXT , FOREIGN KEY(email) REFERENCES users(email) )");
        //DB.execSQL("CREATE TABLE education(_id INTEGER PRIMARY KEY , educationLevel TEXT ,institute TEXT , fieldOfStudies TExt , location TEXT,yearOfGraduation TEXT ,monthOfGraduation TEXT )");
       DB.execSQL("CREATE TABLE educationTable(_id INTEGER PRIMARY KEY , educationLevel TEXT,institute TEXT , fieldOfStudies TExt, location TEXT ,yearOfGraduation TEXT ,monthOfGraduation TEXT,grade TEXT,additionalInformation TEXT , email TEXT , FOREIGN KEY(email) REFERENCES users(email))");
        DB.execSQL("CREATE TABLE work(_id INTEGER PRIMARY KEY , name TEXT,mnemonik TEXT , description TEXT, image TEXT ,domaine TEXT,isSaved INTEGER)");
       // DB.execSQL("CREATE TABLE work(_id INTEGER PRIMARY KEY , name TEXT)");
        DB.execSQL("CREATE TABLE domaineTable(_id INTEGER PRIMARY KEY , domaine TEXT , email TEXT , FOREIGN KEY(email) REFERENCES users(email))" );
        DB.execSQL("create table users(email TEXT primary key,firstName TEXT,familyName TEXT,password TEXT)");
        DB.execSQL("create table currentUserEmail(email TEXT )");
        DB.execSQL("create table skillTable(_id INTEGER PRIMARY KEY ,skillName TEXT,proficiency TEXT , email TEXT , FOREIGN KEY(email) REFERENCES users(email))");
        DB.execSQL("create table languages(_id INTEGER PRIMARY KEY ,languageName TEXT,email TEXT , FOREIGN KEY(email) REFERENCES users(email))");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        /*DB.execSQL("drop Table if exists workExperiencee");
        onCreate(DB);*/
    }
    public boolean insertWorkExperience(workExperience wE,String email){
        SQLiteDatabase DB  = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("jobTitle",wE.getJobTitle());
        contentValues.put("companyName",wE.getCompanyName());
        contentValues.put("specialization",wE.getSpecialization());
        contentValues.put("companyIndusty",wE.getCompanyIndustry());
        contentValues.put("positionLevel",wE.getPositionLevel());
        contentValues.put("startDate",wE.getStartDate());
        contentValues.put("endDate",wE.getEndDate());
        contentValues.put("iCurrentlyWorkHere",wE.getICurrentlyWorkHere());
        contentValues.put("jobDescription",wE.getJobDescription());
        contentValues.put("email", email);
        long isInserted = DB.insert("workExperiencee",null,contentValues);

        if(isInserted==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Boolean insertData(String email,String password,String firstName,String familyName){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("firstName",firstName);
        contentValues.put("familyName",familyName);

        contentValues.put("password",password);

        long result = MyDB.insert("users",null,contentValues);

        if(result == -1) return false;
        else return true;
}
    public Boolean checkEmail(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where email = ?",new String[] {email});

        if(cursor.getCount() > 0){
            return true;
        }else
            return false;

    }

    public Boolean checkPassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("select * from users where email = ? and password = ? ",new String[] {email,password});


        if(cursor.getCount() > 0){
            return true;

        }else {
            return false;
}
}
    public Cursor viewData(String email)
    {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ?",new String[] {email},null);
        return cursor;
}

    public boolean insertEducation(Education education,String email){
        SQLiteDatabase DB  = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("educationLevel",education.getEducationLevel());
        contentValues.put("institute",education.getInstitute());
        contentValues.put("fieldOfStudies",education.getFieldOfStudies());
        contentValues.put("location",education.getLocation());
        contentValues.put("yearOfGraduation",education.getYearOfGraduation());
        contentValues.put("monthOfGraduation",education.getMonthOfGraduation());
        contentValues.put("grade",education.getGrade());
        contentValues.put("additionalInformation",education.getAdditionalInformation());
        contentValues.put("email",email);
        long isInserted = DB.insert("educationTable",null,contentValues);

       if(isInserted==-1){
            return false;
        }
        else{
            return true;
        }

    }
    public boolean insertWork(itemList item){
        SQLiteDatabase DB  = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
       // contentValues.put("jobTitle",wE.getJobTitle());
        contentValues.put("name",item.getName());
        contentValues.put("mnemonik",item.getMnemonic());
        contentValues.put("description",item.getDescription());
        contentValues.put("image",item.getImage());
        contentValues.put("domaine",item.getDomaine());
        contentValues.put("isSaved",1);
        long isInserted = DB.insert("work",null,contentValues);

        if(isInserted==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertDomaine(String domaine,String email){
        SQLiteDatabase DB  = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        // contentValues.put("jobTitle",wE.getJobTitle());
        contentValues.put("domaine",domaine);
        contentValues.put("email",email);
        long isInserted = DB.insert("domaineTable",null,contentValues);

        if(isInserted==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertSkill(Skill skill,String email){
        SQLiteDatabase DB  = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();

        contentValues.put("skillName",skill.getSkillName());
        contentValues.put("proficiency",skill.getProficiency());
        contentValues.put("email",email);
        long isInserted = DB.insert("skillTable",null,contentValues);

        if(isInserted==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertCurrentUserEmail(String email){
        SQLiteDatabase DB  = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        // contentValues.put("jobTitle",wE.getJobTitle());
        contentValues.put("email",email);

        long isInserted = DB.insert("currentUserEmail",null,contentValues);

        if(isInserted==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean insertLanguage(Languages language,String email){
        SQLiteDatabase DB  = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        // contentValues.put("jobTitle",wE.getJobTitle());
        contentValues.put("email",email);
        contentValues.put("languageName",language.getLanguage());

        long isInserted = DB.insert("languages",null,contentValues);

        if(isInserted==-1){
            return false;
        }
        else{
            return true;
        }
    }


    public boolean updateWorkExperience(workExperience wE,int wEId,String email){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
      //  contentValues.put("id",wE.getId());
        contentValues.put("jobTitle",wE.getJobTitle());
        contentValues.put("companyName",wE.getCompanyName());
        contentValues.put("companyIndusty",wE.getCompanyIndustry());
        contentValues.put("specialization",wE.getCompanyIndustry());
        contentValues.put("positionLevel",wE.getPositionLevel());
        contentValues.put("startDate",wE.getStartDate());
        contentValues.put("endDate",wE.getEndDate());
        contentValues.put("iCurrentlyWorkHere",wE.getICurrentlyWorkHere());
        contentValues.put("jobDescription", wE.getJobDescription());
        contentValues.put("email",email);

        long isUpdated = DB.update("workExperiencee",contentValues,"_id=?",new String[]{String.valueOf(wEId)});
        if(isUpdated==-1){
            return false;
        }
        else{
            return true;
        }


    }
    public boolean updateEducation(Education education ,int wEId,String email){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //  contentValues.put("id",wE.getId());
        contentValues.put("educationLevel",education.getEducationLevel());
        contentValues.put("institute",education.getInstitute());
        contentValues.put("fieldOfStudies",education.getFieldOfStudies());
        contentValues.put("location",education.getLocation());
        contentValues.put("yearOfGraduation",education.getYearOfGraduation());
        contentValues.put("monthOfGraduation",education.getMonthOfGraduation());
        contentValues.put("grade",education.getGrade());
        contentValues.put("additionalInformation",education.getAdditionalInformation());
        contentValues.put("email",email);

        long isUpdated = DB.update("educationTable",contentValues,"_id=?",new String[]{String.valueOf(wEId)});
        if(isUpdated==-1){
            return false;
        }
        else{
            return true;
        }


    }
    public Cursor getAllEducation(String email){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from educationTable where email = ?",new String[]{email},null);
        return cursor;
    }
    public Cursor getDomaine(String email){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from domaineTable where email = ?",new String[]{email},null);
        return cursor;
    }
    public Cursor getSkill(String email){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from skill where email = ?",new String[]{email},null);
        return cursor;
    }
    public Cursor getEmail(){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from currentUserEmail",null);
        return cursor;
    }
    public Cursor getAllworkExperience(String email){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from workExperiencee where email = ? ",new String[]{email},null);
        return cursor;
    }
    public Cursor getAllSkill(String email){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from skillTable where email = ? ",new String[]{email},null);
        return cursor;
    }
    public Cursor getAllLanguages(String email){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from languages where email = ? ",new String[]{email},null);
        return cursor;
    }
    public Cursor getAllWork(){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from work",null);
        return cursor;
    }
    public Cursor getSerchedJob(String domaine){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from work where domaine = ? ",new String[]{domaine},null);
     //   Cursor cursor = DB.rawQuery("select * from work ",null);
        return cursor;
    }

    public workExperience getOneWorkExperience(int id){
        SQLiteDatabase DB  = this.getReadableDatabase();
        Cursor cursor = DB.query("workExperiencee",new String[]{"_id","jobTitle","companyName","specialization","companyIndustry","positionLevel","startDate","endDate","iCurrentlyWorkHere","jobDescription"},"_id=?", new String[]{String.valueOf(id)},null,null,null);
        cursor.moveToFirst();
        workExperience wE = new workExperience(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getInt(8),cursor.getString(9));
        return wE;
    }


}
