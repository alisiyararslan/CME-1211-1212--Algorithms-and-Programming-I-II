using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace homework3
{
    class Program
    {
        static void Main(string[] args)
        {

            
            string check;
            int counter = 0;
            string repetion = "Repetition:  ";
            string type = "Type:  ";
            StreamReader file = File.OpenText("poem.txt");
            do//how many lines the poem is in total
            {
                check= file.ReadLine();
                counter++;
            } while (check!=null);
            counter--;
            file.Close();
            //Console.WriteLine(counter);
            
            string[] row2 = new string[counter];
            string[] row = new string[counter];
            StreamReader file2 = File.OpenText("poem.txt");
            for (int i = 0; i < counter; i++)//Assign the poem to the series
            {
                
                row[i]= file2.ReadLine();
            }
            file2.Close();
            
            
            
            

            string reverse=null,reverse2=null;//reverse the array
            for (int i = 0; i < counter; i++)
            {
                
                reverse2 = "";
                reverse = row[i];
                
                for (int j = reverse.Length - 1; j >= 0; j--)
                {
                    reverse2 = reverse2 + reverse[j];
                }
                row2[i] = reverse2;
                
            }
            
            

            bool flag = true;
            char a='a';
            int counter2=0,step=0, counter3 = 0;
            Console.WriteLine();
            //Types of Rhymes (according to the characteristics of the repeating sounds)
            for (int j = 0; j < 30; j++)
            {
                for (int i = 0; i < counter; i++)
                {
                    if (i==0)//reference the first word of the poem in each column
                    {
                        a = row2[i][j];
                        counter2 = 0;
                    }
                    else//control of other lines
                    {
                        if (row2[i][j] != a)
                        {
                            step = j;
                            flag = false;
                            
                            break;
                        }
                        if ((row2[i][j] == a)&&(a == ' '))
                        {
                            counter2++;
                        }
                    }
                    
                }
                if (flag==false)
                {
                    break;
                }
                if (counter2==counter-1)
                {
                    counter3++;
                }
                
            }
            
            if (step>0)//type of poem
            {
                if (counter3>=2)
                {
                    type+="Phrase Rhyme (Sözcük Öbeği Redifi)";
                }
                else if (counter3==1)
                {
                    type +="Word Rhyme(Sözcük Redifi)";
                }
                else
                {
                    type += "Additional Rhymes (Ek Redif)";
                }
            }
            //repeating words

            for (int i = step-1; i >=0 ; i--)
            {
                repetion+= row2[1][i];
            }
            Console.WriteLine(repetion);
            Console.WriteLine(type);
            

            

            //Alternating Rhyme (Çapraz Uyak)
            bool flag2 = true, flag3 = true, flag4 = true, flag5 = true;
            char Aa = '-', Bb = '-',Cc = '-',Dd = '-';
            int  step2 = 50, step3 = 50, step4 = 50, step5 = 50;

            Console.WriteLine();
            
            for (int j = 0; j < 20; j++)
            {
                
                for (int i = 0; i < counter; i++)
                {
                    if (i == 0)//columns to reference
                    {
                        Aa = row2[i][j];
                        counter2 = 0;
                    }
                    else if (i==1&& row2[i][j]!=Aa)//columns to reference
                    {
                        Bb = row2[i][j];
                    }
                    else if (i==4)//columns to reference
                    {
                        Cc = row2[i][j];
                    }
                    else if (i==5 && row2[i][j] != Aa)//columns to reference
                    {
                        Dd = row2[i][j];
                    }
                    else if (i==2)//columns to check.
                    {
                        if (row2[i][j]!=Aa && flag2==true )
                        {
                            flag2 = false;
                            step2 = j;
                        }
                    }
                    else if (i == 3)//columns to check.
                    {
                        if (row2[i][j] != Bb && flag3 == true)
                        {
                            flag3 = false;
                            step3= j;
                        }
                    }
                    else if (i == 6)//columns to check.
                    {
                        if (row2[i][j] != Cc && flag4 == true)
                        {
                            flag4 = false;
                            step4 = j;
                        }
                    }
                    else if (i == 7)//columns to check.
                    {
                        if (row2[i][j] != Dd && flag5 == true)
                        {
                            flag5 = false;
                            step5 = j;
                        }
                    }

                    

                }
                if (!(flag2 || flag3 || flag4 || flag5) )
                {
                    break;
                }

            }
            //Required controls to avoid species interference
            if (step2 == 0)
            {
                flag2 = true;
            }
            if (step3 == 0)
            {
                flag3 = true;
            }
            if (step4 == 0)
            {
                flag4 = true;
            }
            if (step5 == 0)
            {
                flag5 = true;
            }
            if (step4 == 50)
            {
                flag4 = false;
            }
            if (step5 == 50)
            {
                flag5 = false;
            }
            string repet2 = "Repetitions: ";//repeted words
            if (!(flag2 || flag3 || flag4 || flag5))
            {
                repet2 += "A- ";
                for (int i = step2 - 1; i >= 0; i--)
                {
                    repet2 += row2[0][i];
                }
                repet2 += " B- ";
                for (int i = step3 - 1; i >= 0; i--)
                {
                    repet2 += row2[1][i] ;
                }
                if (step4!=50)
                {
                    repet2 += " C- ";
                    for (int i = step4 - 1; i >= 0; i--)
                    {
                        repet2 += row2[4][i];
                    }
                }
                if (step5 != 50)
                {
                    repet2 += " D- ";
                    for (int i = step5 - 1; i >= 0; i--)
                    {
                        repet2 += row2[5][i];
                    }
                }

                Console.WriteLine(repet2);
                Console.WriteLine("Alternating Rhyme (Çapraz Uyak)");
            }

            // Winding Rhyme (Sarma Uyak)
            bool flag22 = true, flag33 = true, flag44 = true, flag55 = true;
            Aa = '-'; Bb = '-'; Cc = '-'; Dd = '-';
            step2 = 50; step3 = 50; step4 = 50; step5 = 50;
            Console.WriteLine();

            for (int j = 0; j < 20; j++)
            {

                for (int i = 0; i < counter; i++)
                {
                    if (i == 0)//columns to reference
                    {
                        Aa = row2[i][j];
                        
                    }
                    else if (i == 1 && row2[i][j] != Aa)//columns to reference
                    {
                        Bb = row2[i][j];
                    }
                    else if (i == 4)//columns to reference
                    {
                        Cc = row2[i][j];
                    }
                    else if (i == 5 && row2[i][j] != Cc)//columns to reference
                    {
                        Dd = row2[i][j];
                    }
                    else if (i == 3)//columns to check.
                    {
                        if (row2[i][j] != Aa && flag22 == true)
                        {
                            flag22 = false;
                            step2 = j;
                        }
                    }
                    else if (i == 2)//columns to check.
                    {
                        if (row2[i][j] != Bb && flag33 == true)
                        {
                            flag33 = false;
                            step3 = j;
                        }
                    }
                    else if (i == 7)//columns to check.
                    {
                        if (row2[i][j] != Cc && flag44 == true)
                        {
                            flag44 = false;
                            step4 = j;
                        }
                    }
                    else if (i == 6)//columns to check.
                    {
                        if (row2[i][j] != Dd && flag55 == true)
                        {
                            flag55 = false;
                            step5 = j;
                        }
                    }
                }
                if (!(flag22 || flag33 || flag44 || flag55))
                {
                    break;
                }


            }
            //Required controls to avoid species interference
            if (step2 == 0)
            {
                flag22 = true;
            }
            if (step3 == 0)
            {
                flag33 = true;
            }
            if (step4 == 0)
            {
                flag44 = true;
            }
            if (step5 == 0)
            {
                flag55 = true;
            }
            if (step4 == 50)
            {
                flag44 = false;
            }
            if (step5 == 50)
            {
                flag55 = false;
            }

            if (!(flag22 || flag33 || flag44 || flag55))//repeted words
            {
                repet2 += "A- ";
                for (int i = step2 - 1; i >= 0; i--)
                {
                    repet2 += row2[0][i];
                }
                repet2 += " B- ";
                for (int i = step3 - 1; i >= 0; i--)
                {
                    repet2 += row2[1][i];
                }
                if (step4 != 50)
                {
                    repet2 += " C- ";
                    for (int i = step4 - 1; i >= 0; i--)
                    {
                        repet2 += row2[4][i];
                    }
                }
                
                if (step5 != 50)
                {
                    repet2 += " D- ";
                for (int i = step5 - 1; i >= 0; i--)
                {
                    repet2 += row2[5][i];
                }
                }
                Console.WriteLine(repet2);
                Console.WriteLine("Winding Rhyme (Sarma Uyak)");
            }

            // - Hoarse Rhyme (Örüşük Uyak)
            flag22 = true; flag33 = true; flag44 = true; flag55 = true;
            Aa = '-'; Bb = '-'; Cc = '-'; Dd = '-';
            step2 = 50; step3 = 50; step4 = 50; 
            Console.WriteLine();

            for (int j = 0; j < 20; j++)
            {

                for (int i = 0; i < counter; i++)
                {
                    if (i == 0)//columns to reference
                    {
                        Aa = row2[i][j];

                    }
                    else if (i == 1)//columns to reference
                    {
                        Bb = row2[i][j];
                    }
                    else if (i == 4)//columns to reference
                    {
                        Cc = row2[i][j];
                    }
                    
                    else if (i == 2)//columns to check.
                    {
                        if (row2[i][j] != Aa && flag22 == true)
                        {
                            flag22 = false;
                            step2 = j;
                        }
                    }
                    else if (i == 3)//columns to check.
                    {
                        if (row2[i][j] != Bb && flag33 == true)
                        {
                            flag33 = false;
                            step3 = j;
                        }
                    }
                    else if (i == 5)//columns to check.
                    {
                        if (row2[i][j] != Bb && flag33 == true)
                        {
                            flag33 = false;
                            step3 = j;
                        }
                    }
                    else if (i == 6)//columns to check.
                    {
                        if (row2[i][j] != Cc && flag44 == true)
                        {
                            flag44 = false;
                            step4 = j;
                        }
                    }
                    else if (i == 8)//columns to check.
                    {
                        if (row2[i][j] != Cc && flag44 == true)
                        {
                            flag44 = false;
                            step4 = j;
                        }
                    }

                }
                if (!(flag22 || flag33 || flag44 ))
                {
                    break;
                }

            }
            //Required controls to avoid species interference
            if (step2 == 0)
            {
                flag22 = true;
            }
            if (step3 == 0)
            {
                flag33 = true;
            }
            if (step4 == 0)
            {
                flag44 = true;
            }
            
            if (step4 == 50)
            {
                flag44 = false;
            }
            

            if (!(flag22 || flag33 || flag44 ))//repeted words
            {
                repet2 += "A- ";
                for (int i = step2 - 1; i >= 0; i--)
                {
                    repet2 += row2[0][i];
                }
                repet2 += " B- ";
                for (int i = step3 - 1; i >= 0; i--)
                {
                    repet2 += row2[1][i];
                }
                if (step4 != 50)
                {
                    repet2 += " C- ";
                    for (int i = step4 - 1; i >= 0; i--)
                    {
                        repet2 += row2[4][i];
                    }
                }

                
                Console.WriteLine(repet2);
                Console.WriteLine("Hoarse Rhyme (Örüşük Uyak)");
            }

            //- Straight Rhyme (Düz Uyak)
            flag22 = true; flag33 = true; flag44 = true; flag55 = true;
            Aa = '-'; Bb = '-'; Cc = '-'; Dd = '-';
            step2 = 50; step3 = 50; step4 = 50;
            Console.WriteLine();

            for (int j = 0; j < 20; j++)
            {

                for (int i = 0; i < counter; i++)
                {
                    if (i == 0)//columns to reference
                    {
                        Aa = row2[i][j];

                    }
                    else if (i == 3 && counter==6)//columns to reference
                    {
                        Bb = row2[i][j];
                    }
                    else if (i == 4 && counter ==8)//columns to reference
                    {
                        Bb = row2[i][j];
                    }
                    else if (i == 1)
                    {
                        if (row2[i][j] != Aa && flag22 == true)//columns to check.
                        {
                            flag22 = false;
                            step2 = j;
                        }
                    }
                    else if (i == 2)
                    {
                        if (row2[i][j] != Aa && flag22 == true)//columns to check.
                        {
                            flag22 = false;
                            step2 = j;
                        }
                    }
                    else if (i == 3 && counter==8)
                    {
                        if (row2[i][j] != Aa && flag22 == true)//columns to check.
                        {
                            flag22 = false;
                            step2 = j;
                        }
                    }
                    else if (i == 4&& counter==6)
                    {
                        if (row2[i][j] != Bb && flag33 == true)//columns to check.
                        {
                            flag33 = false;
                            step3 = j;
                        }
                    }
                    else if (i == 5)
                    {
                        if (row2[i][j] != Bb && flag33 == true)//columns to check.
                        {
                            flag33 = false;
                            step3 = j;
                        }
                    }
                    if (counter==8)
                    {
                        if (i == 6)
                        {
                            if (row2[i][j] != Bb && flag33 == true)//columns to check.
                            {
                                flag33 = false;
                                step3 = j;
                            }
                        }
                        else if (i == 7)
                        {
                            if (row2[i][j] != Bb && flag33 == true)//columns to check.
                            {
                                flag33 = false;
                                step3 = j;
                            }
                        }
                    }
                    

                }
                

            }
            //Required controls to avoid species interference
            if (step2 == 0)
            {
                flag22 = true;
            }
            if (step3 == 0)
            {
                flag33 = true;
            }

            if (!(flag22 || flag33 ))//repeted words
            {
                repet2 += "A- ";
                for (int i = step2 - 1; i >= 0; i--)
                {
                    repet2 += row2[0][i];
                }
                repet2 += " B- ";
                for (int i = step3 - 1; i >= 0; i--)
                {
                    repet2 += row2[5][i];
                }
                


                Console.WriteLine( repet2);
                Console.WriteLine("Straight Rhyme (Düz Uyak)");
            }

            Console.ReadLine();
        }
    }
}
