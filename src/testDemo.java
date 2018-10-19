import edu.princeton.cs.algs4.CollisionSystem;
import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class testDemo {
    public static void main(String[] args) {
        testDemo test = new testDemo();
        int n = 50;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.random();
        }
        for (int i = 0; i < a.length; i++) {
            double x = 1.0 * i / n;
            double y = a[i] / 2.0;
            double rw = 0.5 / n;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    private void beauty() {
        int n = 20; //粒子数(默认为20)
//        if (args.length == 1) {
//            n = Integer.parseInt(args[0]);
//        }

        //启用双缓冲以支持动画
        StdDraw.enableDoubleBuffering();

        //创建n个粒子
        Particle[] particles = new Particle[n];
        for (int i = 0; i < n; i++) {
            particles[i] = new Particle();
        }

        //模拟系统
        CollisionSystem system = new CollisionSystem(particles);
        system.simulate(Double.POSITIVE_INFINITY);
    }
}
