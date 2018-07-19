package com.example.yyyy.finalbad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText m1t1;
    private EditText m1t2;
    private EditText m2t1;
    private EditText m2t2;
    private EditText m3t1;
    private EditText m3t2;
    private EditText m1s;
    private EditText m2s;
    private EditText m3s;
    private TextView res;
    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1t1 = (EditText) findViewById(R.id.M1T1);
        m1t2 = (EditText) findViewById(R.id.M1T2);
        m2t1 = (EditText) findViewById(R.id.M2T1);
        m2t2 = (EditText) findViewById(R.id.M2T2);
        m3t1 = (EditText) findViewById(R.id.M3T1);
        m3t2 = (EditText) findViewById(R.id.M3T2);
        res  = (TextView) findViewById(R.id.res);
        m1s  = (EditText) findViewById(R.id.M1S);
        m2s  = (EditText) findViewById(R.id.M2S);
        m3s  = (EditText) findViewById(R.id.M3S);
        btn  = (Button)   findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String M1T1 = m1t1.getText().toString();
                String M1T2 = m1t2.getText().toString();
                //String M2T1 = m2t1.getText().toString();
                String M2T2 = m2t2.getText().toString();
                //String M3T1 = m3t1.getText().toString();
                //String M3T2 = m3t2.getText().toString();
                String Match1res = m1s.getText().toString();
                String Match2res = m2s.getText().toString();
                String Match3res = m3s.getText().toString();
                Match1res = Match1res.replaceAll("\\s+","");
                Match2res = Match2res.replaceAll("\\s+","");
                Match3res = Match3res.replaceAll("\\s+","");


                String[] Match1sets = Match1res.split(",");
                String[] Match2sets = Match2res.split(",");
                String[] Match3sets = Match3res.split(",");


                String[] Match1set1 = Match1sets[0].split("-");
                String[] Match1set2 = Match1sets[1].split("-");
                String[] Match1set3 = Match1sets[2].split("-");

                String[] Match2set1 = Match2sets[0].split("-");
                String[] Match2set2 = Match2sets[1].split("-");
                String[] Match2set3 = Match2sets[2].split("-");

                String[] Match3set1 = Match3sets[0].split("-");
                String[] Match3set2 = Match3sets[1].split("-");
                String[] Match3set3 = Match3sets[2].split("-");

                int[] setd =new int[]{0,0,0};
                int[] pointd =new int[]{0,0,0,0,0,0};
                //int[] fpointd =new int[]{0,0,0};

                int m1s1t1 = Integer.parseInt(Match1set1[0]);
                int m1s1t2 = Integer.parseInt(Match1set1[1]);
                int m1s2t1 = Integer.parseInt(Match1set2[0]);
                int m1s2t2 = Integer.parseInt(Match1set2[1]);
                int m1s3t1 = Integer.parseInt(Match1set3[0]);
                int m1s3t2 = Integer.parseInt(Match1set3[1]);

                int m2s1t1 = Integer.parseInt(Match2set1[0]);
                int m2s1t2 = Integer.parseInt(Match2set1[1]);
                int m2s2t1 = Integer.parseInt(Match2set2[0]);
                int m2s2t2 = Integer.parseInt(Match2set2[1]);
                int m2s3t1 = Integer.parseInt(Match2set3[0]);
                int m2s3t2 = Integer.parseInt(Match2set3[1]);

                int m3s1t1 = Integer.parseInt(Match3set1[0]);
                int m3s1t2 = Integer.parseInt(Match3set1[1]);
                int m3s2t1 = Integer.parseInt(Match3set2[0]);
                int m3s2t2 = Integer.parseInt(Match3set2[1]);
                int m3s3t1 = Integer.parseInt(Match3set3[0]);
                int m3s3t2 = Integer.parseInt(Match3set3[1]);

                int t1p=0,t2p=0,t3p=0;
                /*
                int [] total = new int[]{0,0,0,0,0,0};

                total[0] = m1s1t1+m1s2t1+m1s3t1;
                total[1] = m1s1t2+m1s2t2+m1s3t2;

                total[2] = m2s1t1+m2s2t1+m2s3t1;
                total[3] = m2s1t2+m2s2t2+m2s3t2;

                total[4] = m3s1t1+m3s2t1+m3s3t1;
                total[5] = m3s1t2+m3s2t2+m3s3t2;*/

                boolean score[] = new boolean[]{false,false,false,false,false,false,false,false,false};
                if (m1s1t1>m1s1t2)
                    score[0]=true;
                if (m1s2t1>m1s2t2)
                    score[1]=true;
                if (m1s3t1>m1s3t2)
                    score[2]=true;

                if (m2s1t1>m2s1t2)
                    score[3]=true;
                if (m2s2t1>m2s2t2)
                    score[4]=true;
                if (m2s3t1>m2s3t2)
                    score[5]=true;

                if (m3s1t1>m3s1t2)
                    score[6]=true;
                if (m3s2t1>m3s2t2)
                    score[7]=true;
                if (m3s3t1>m3s3t2)
                    score[8]=true;

                if (score[0] && score[1])
                    t1p++;
                if (!score[0] && !score[1])
                    t2p++;
                if (score[0] && !score[1] && score[2])
                    t1p++;
                if (!score[0] && score[1] && !score[2])
                    t2p++;
                if (score[0] && !score[1] && !score[2])
                    t2p++;
                if (!score[0] && score[1] && score[2])
                    t1p++;


                if (score[3] && score[4])
                    t2p++;
                if (!score[3] && !score[4])
                    t3p++;
                if (score[3] && !score[4] && score[5])
                    t2p++;
                if (!score[3] && score[4] && !score[5])
                    t3p++;
                if (!score[3] && score[4] && score[5])
                    t2p++;
                if (score[3] && !score[4] && !score[5])
                    t3p++;

                if (score[6] && score[7])
                    t1p++;
                if (!score[6] && !score[7])
                    t3p++;
                if (score[6] && !score[7] && score[8])
                    t1p++;
                if (!score[6] && score[7] && !score[8])
                    t3p++;
                if (!score[6] && score[7] && score[8])
                    t1p++;
                if (score[6] && !score[7] && !score[8])
                    t3p++;

/*
                String M1T1="A";
                String M1T2="B";
                String M2T2="C";*/

                int t1f=0,t2f=0,t3f=0;





                //String eli="";

                /*pointd[0]= (m1s1t1-m1s1t2) + (m1s2t1-m1s2t2) + (m1s3t1-m1s3t2) + (m3s1t1-m3s1t2) + (m3s2t1-m3s2t2) + (m3s3t1-m3s3t2) ;
                pointd[1]= (m2s1t1-m2s1t2) + (m2s2t1-m2s2t2) + (m2s3t1-m2s3t2) + (m1s1t2-m1s1t1) + (m1s2t2-m1s2t1) + (m1s3t2-m1s3t1) ;
                pointd[2]= (m2s1t2-m2s1t1) + (m2s2t2-m2s2t1) + (m2s3t2-m2s3t1) + (m3s1t2-m3s1t1) + (m3s2t2-m3s2t1) + (m3s3t2-m3s3t1) ; */

                pointd[0] = (m1s1t1-m1s1t2) + (m1s2t1-m1s2t2) + (m1s3t1-m1s3t2);
                pointd[1] = (m1s1t2-m1s1t1) + (m1s2t2-m1s2t1) + (m1s3t2-m1s3t1);
                pointd[2] = (m2s1t1-m2s1t2) + (m2s2t1-m2s2t2) + (m2s3t1-m2s3t2);
                pointd[3] = (m2s1t2-m2s1t1) + (m2s2t2-m2s2t1) + (m2s3t2-m2s3t1);
                pointd[4] = (m3s1t1-m3s1t2) + (m3s2t1-m3s2t2) + (m3s3t1-m3s3t2);
                pointd[5] = (m3s1t2-m3s1t1) + (m3s2t2-m3s2t1) + (m3s3t2-m3s3t1);


                int pd1 = pointd[0]+pointd[4];
                int pd2 = pointd[1]+pointd[2];
                int pd3 = pointd[3]+pointd[5];


               /* if (t1p == 1 && t2p == 1 && t3p == 1)
                {
                    System.out.println("Hello");*/
                if (m1s1t1 > m1s1t2)
                {
                    setd[0]++;
                    setd[1]--;
                }
                else if (m1s1t1 < m1s1t2)
                {
                    setd[1]++;
                    setd[0]--;
                }
                if (m1s2t1 > m1s2t2)
                {
                    setd[0]++;
                    setd[1]--;
                }
                else if (m1s2t1 < m1s2t2)
                {
                    setd[1]++;
                    setd[0]--;
                }
                if (m1s3t1 > m1s3t2)
                {
                    setd[0]++;
                    setd[1]--;
                }
                else if (m1s3t1 < m1s3t2)
                {
                    setd[1]++;
                    setd[0]--;
                }
                if (m2s1t1 > m2s1t2)
                {
                    setd[1]++;
                    setd[2]--;
                }
                else if (m2s1t1 < m2s1t2)
                {
                    setd[2]++;
                    setd[1]--;
                }
                if (m2s2t1 > m2s2t2)
                {
                    setd[1]++;
                    setd[2]--;
                }
                else if (m2s2t1 < m2s2t2)
                {
                    setd[2]++;
                    setd[1]--;
                }
                if (m2s3t1 > m2s3t2)
                {
                    setd[1]++;
                    setd[2]--;
                }
                else if (m2s3t1 < m2s3t2)
                {
                    setd[2]++;
                    setd[1]--;
                }
                if (m3s1t1 > m1s1t2)
                {
                    setd[0]++;
                    setd[2]--;
                }
                else if (m3s1t1 < m3s1t2)
                {
                    setd[2]++;
                    setd[0]--;
                }
                if (m3s2t1 > m3s2t2)
                {
                    setd[0]++;
                    setd[2]--;
                }
                else if (m3s2t1 < m3s2t2)
                {
                    setd[2]++;
                    setd[0]--;
                }
                if (m3s3t1 > m3s3t2)
                {
                    setd[0]++;
                    setd[2]--;
                }
                else if (m3s3t1 < m3s3t2)
                {
                    setd[2]++;
                    setd[0]--;
                }


                /*
                if(t1p == 1 && t2p == 1 && t3p == 1)
                {
                    int a=setd[0],b=setd[1],c=setd[2],d;

                    //System.out.println(a);
                    //System.out.println(b);
                    //System.out.println(c);

                    d= Math.max(a, Math.max(b, c));
                    //System.out.println(d);

                    System.out.println("Smallest is "+ Integer.toString(d));

                    if(d==setd[0])
                        t1f--;

                    if(d==setd[1])
                        t2f--;

                    if(d==setd[2])
                        t3f--;


                }
                if(a == b && b== c && c==a)
                    {
                        System.out.println("Use point Diff ");
                        int g1=pd1,c1=pd2,d1=pd3;
                        if(g1<c1 && g1<d1)
                            t1f--;
                        else if (c1<g1 && c1<d1)
                            t2f--;
                        else if(d1<c1 && d1<g1)
                            t3f--;
                        else if(g1==c1 && c1==d1)
                            {
                                t1f =-2;
                                t2f =-2;
                                t3f =-2;
                            }
                    }
                */


                // System.out.println("Eliminated Team is :"+ eli);

                System.out.println("Point Difference");
                System.out.println(pd1);
                System.out.println(pd2);
                System.out.println(pd3);

                System.out.println("Set Difference");
                System.out.println(setd[0]);
                System.out.println(setd[1]);
                System.out.println(setd[2]);
                System.out.println("Point Table");
                System.out.println(t1p);
                System.out.println(t2p);
                System.out.println(t3p);
                System.out.println("POINTS");
                System.out.println(pointd[0]);
                System.out.println(pointd[1]);
                System.out.println(pointd[2]);
                System.out.println(pointd[3]);
                System.out.println(pointd[4]);
                System.out.println(pointd[5]);

                if (t1p == 0)
                    t1f++;
                if (t2p == 0)
                    t2f++;
                if (t3p == 0)
                    t3f++;
                int temppd=0;
                if (t1p == 1 && t2p == 1 && t3p == 1)
                {
                    if ((setd[0]==setd[1]) && (setd[1]==setd[2]))
                    {
                        if (pd1==pd2 && pd2==pd3)
                        {
                            t1f=-10;
                            t2f=-10;
                            t3f=-10;
                        }
                        temppd = Math.min(pd1, Math.min(pd2, pd3));
                        if(temppd==pd1)
                            t1f++;
                        if(temppd==pd2)
                            t2f++;
                        if(temppd==pd3)
                            t3f++;
                    }
                    if(temppd==0){
                        int temp = Math.max(setd[0], Math.max(setd[1], setd[2]));
                        int tempa=0,tempb=0;
                        if (temp==setd[0])
                        {
                            if (m2s1t1 > m2s1t2)
                                tempa++;
                            else if (m2s1t1 < m2s1t2)
                                tempb++;
                            if (m2s2t1 > m2s2t2)
                                tempa++;
                            else if (m2s2t1 < m2s2t2)
                                tempb++;
                            if (m2s3t1 > m2s3t2)
                                tempa++;
                            else if (m2s3t1 < m2s3t2)
                                tempb++;
                            if (tempa>tempb)
                                t3f++;
                            else if(tempa<tempb)
                                t2f++;
                        }


                        else if(temp==setd[1])
                        {
                            if (m3s1t1 > m1s1t2)
                                tempa++;
                            else if (m3s1t1 < m3s1t2)
                                tempb++;
                            if (m3s2t1 > m3s2t2)
                                tempa++;
                            else if (m3s2t1 < m3s2t2)
                                tempb++;
                            if (m3s3t1 > m3s3t2)
                                tempa++;
                            else if (m3s3t1 < m3s3t2)
                                tempb++;
                            if (tempa>tempb)
                                t3f++;
                            else if(tempa<tempb)
                                t1f++;
                        }

                        else if(temp==setd[0])
                        {
                            if (m1s1t1 > m1s1t2)
                                tempa++;
                            else if (m1s1t1 < m1s1t2)
                                tempb++;
                            if (m1s2t1 > m1s2t2)
                                tempa++;
                            else if (m1s2t1 < m1s2t2)
                                tempb++;
                            if (m1s3t1 > m1s3t2)
                                tempa++;
                            else if (m1s3t1 < m1s3t2)
                                tempb++;
                            if (tempa>tempb)
                                t2f++;
                            else if(tempa<tempb)
                                t1f++;

                        }
                    }
                }
                if (t1f==1)
                    res.setText("Eliminated is "+M1T1);
                    //System.out.println("Eliminated is A");
                if (t2f==1)
                    res.setText("Eliminated is "+M1T2);
                    //System.out.println("Eliminated is B");
                if (t3f==1)
                    res.setText("Eliminated is "+M2T2);
                    //System.out.println("Eliminated is C");
                if (t1f==-10 && t2f==-10 && t3f==-10)
                    res.setText("All Parameters are Same");





                /*String part1 = parts[0]; // 004
                String part2 = parts[1]; // 034556*/

            }
        });

    }
}
