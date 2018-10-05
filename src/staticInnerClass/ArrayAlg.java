package staticInnerClass;

class ArrayAlg {
    /**
     * Пара чисел с плавающей точкой
     */
    public static class Pair {
        private double first;
        private double second;

        /**
         * Составляет пару их двух чисел с плавающей точкой
         * @param f Первое число
         * @param s Второе число
         */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * Возвращает первое число из пары
         * @return Возврат первого числа
         */
        public double getFirst() {
            return first;
        }

        /**
         * Возвращает первое число из пары
         * @return Возврат первого числа
         */
        public double getSecond() {
            return second;
        }

        /**
         * Определяет минимальное и максимальное числа в массиве
         * @param values Массив чисел с плавающей точкой
         * @return Пара, первым элементом которой является минимальное
         * число, а вторым элементом - максимальное число
         */
        public static Pair minmax(double[] values) {
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            for (double v : values){
                if (min > v) min = v;
                if (max < v) max = v;
            }
            return new Pair(min, max);
        }
    }
}