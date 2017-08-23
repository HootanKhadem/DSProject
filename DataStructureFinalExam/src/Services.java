import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Nader on 8/19/2017.
 */
public class Services
{
    private ArrayList<Course> coursesList = new ArrayList<>();

    private boolean foundPrerequisite2 = false;
    private boolean foundPrerequisite1;


    void start()
    {
        LinkedList<LinkedList<String>> stringNodes = loadCourseInfo("computer.csv");
        int iterationCounter = 0;
        while (iterationCounter < 70)
        {
            stringNodes.iterator().next();
            if (iterationCounter == 0)
            {
                iterationCounter++;
                stringNodes.iterator().next();
            }
            if (iterationCounter <= 70)
            {
                String line = String.valueOf(stringNodes.get(iterationCounter));
                String[] courses = line.split(",");
                Course prerequisite1 = new Course();
                Course prerequisite2 = new Course();
                Course corequisites = new Course();
                switch (courses.length)
                {
                    case 4:

                        for (int i = 0; i < courses.length; i++)
                        {
                            courses[i] = courses[i].replace("]", "");

                        }
                        Course c = new Course(courses[1], courses[2], courses[3], null, null, null);
                        coursesList.add(c);
                        break;
                    case 5:

                        for (int i = 0; i < courses.length; i++)
                        {
                            courses[i] = courses[i].replace("]", "");

                        }

                        for (Course course :
                                coursesList)
                        {
                            if (course.getName().equals(courses[4]))
                            {
                                prerequisite1 = course;
                                break;
                            }
                        }
                        Course c1 = new Course(courses[1], courses[2], courses[3], prerequisite1, null, null);
                        coursesList.add(c1);
                        break;
                    case 6:

                        for (int i = 0; i < courses.length; i++)
                        {
                            courses[i] = courses[i].replace("]", "");

                        }
                        foundPrerequisite1 = false;
                        for (Course course :
                                coursesList)
                        {

                            if (!foundPrerequisite1)
                            {
                                if (course.getName().equals(courses[4]))
                                {
                                    prerequisite1 = course;
                                    foundPrerequisite1 = true;
                                }
                            }
                            if (course.getName().equals(courses[5]))
                            {
                                prerequisite2 = course;
                                break;
                            }
                        }
                        Course c2 = new Course(courses[1], courses[2], courses[3], prerequisite1, prerequisite2, null);
                        coursesList.add(c2);
                        foundPrerequisite1 = false;
                        break;

                    case 7:
                        for (int i = 0; i < courses.length; i++)
                        {
                            courses[i] = courses[i].replace("]", "");

                        }

                        for (Course course :
                                coursesList)
                        {
                            if (!foundPrerequisite1)
                            {
                                if (course.getName().equals(courses[4]))
                                {
                                    prerequisite1 = course;
                                    foundPrerequisite1 = true;
                                }
                            }

                            if (!foundPrerequisite2)
                            {
                                if (course.getName().equals(courses[5]))
                                {
                                    prerequisite2 = course;
                                    foundPrerequisite2 = true;
                                }
                            }
                            if (course.getName().equals(courses[6]))
                            {
                                corequisites = course;
                                break;
                            }
                        }
                        Course c3 = new Course(courses[1], courses[2], courses[3], prerequisite1, prerequisite2, corequisites);
                        coursesList.add(c3);
                        foundPrerequisite1 = false;
                        foundPrerequisite2 = false;
                        break;
                }

//
                System.out.println("");
                stringNodes.iterator().next();
                iterationCounter++;
            } else
            {
                stringNodes.iterator().next();
            }

        }
        createGraph(coursesList);

    }

    private LinkedList<LinkedList<String>> loadCourseInfo(String fileName)
    {
        LinkedList<LinkedList<String>> stringNodes;
        stringNodes = CSVUtil.readCSV(fileName);
        return stringNodes;
    }

    private void createGraph(ArrayList<Course> coursesList)
    {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int j = 0; j < coursesList.size(); j++)
        {
            Node n = new Node(coursesList.get(j));
            nodes.add(n);
        }


        for (Node node :
                nodes)
        {

            Course prerequisite1 = node.getCourse().getPrerequisite1();
            if (prerequisite1 != null)
            {
                Course prerequisite2 = node.getCourse().getPrerequisite2();
                if (prerequisite2 != null)
                {

                    for (Node tempNode :
                            nodes)
                    {


                        if (tempNode.getCourse().equals(prerequisite1))
                        {
                            tempNode.getAdjacencyList().add(node);
                        }


                        if (tempNode.getCourse().equals(prerequisite2))
                        {
                            tempNode.getAdjacencyList().add(node);
                        }
                    }

                } else
                {
                    for (Node tempNode :
                            nodes)
                    {
                        if (tempNode.getCourse().equals(prerequisite1))
                        {
                            tempNode.getAdjacencyList().add(node);
                            break;
                        }
                    }
                }
            }

        }


//fixme: adjacency list is not being created :D
        System.out.println("");
    }


}
