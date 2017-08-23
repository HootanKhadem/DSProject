/**
 * Created by Nader on 8/17/2017.
 */
public class Course
{
    private String code;
    private String numberOfUnits;
    private String name;
    private Course Prerequisite1;
    private Course Prerequisite2;
    private Course corequisites;

    public Course()
    {
    }



    public Course(String code, String numberOfUnits, String name, Course prerequisite1, Course prerequisite2, Course corequisites)
    {
        this.code = code;
        this.numberOfUnits = numberOfUnits;
        this.name = name;
        Prerequisite1 = prerequisite1;
        Prerequisite2 = prerequisite2;
        this.corequisites = corequisites;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Course getCorequisites()
    {
        return corequisites;
    }

    public void setCorequisites(Course corequisites)
    {
        this.corequisites = corequisites;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNumberOfUnits()
    {
        return numberOfUnits;
    }

    public void setNumberOfUnits(String numberOfUnits)
    {
        this.numberOfUnits = numberOfUnits;
    }
    public Course getPrerequisite1()
    {
        return Prerequisite1;
    }

    public void setPrerequisite1(Course prerequisite1)
    {
        Prerequisite1 = prerequisite1;
    }

    public Course getPrerequisite2()
    {
        return Prerequisite2;
    }

    public void setPrerequisite2(Course prerequisite2)
    {
        Prerequisite2 = prerequisite2;
    }
}
