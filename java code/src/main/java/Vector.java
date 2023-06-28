import java.util.Arrays;

public class Vector {
    private double[] doubElements;

    public Vector(double[] _elements) {
        this.doubElements = _elements;
    }

    public double getElementatIndex(int _index) {

            if (_index >=0 && _index <doubElements.length)
            {
                return doubElements[_index];
            }
            else
            {
                return -1;
            }
    }

    public void setElementatIndex(double _value, int _index) {

        if (_index >=0 && _index <doubElements.length)
        {
            doubElements[_index] = _value;
        }
        else
        {
            doubElements[_index -1] = _value;
        }
    }

    public double[] getAllElements() {
        return doubElements;
    }

    public int getVectorSize() {
        return doubElements.length;
    }

    public Vector reSize(int _size)
    {
        Vector v1 =  new Vector(doubElements);
        try
        {
            double myDouble[] = new double[_size];
            if (_size == doubElements.length)
            {
                return new Vector(doubElements);
            } else if (_size <= 0)
            {
                return new Vector(doubElements);
            }
            else if (_size<doubElements.length)
            {
                for (int i = 0; i<_size; i++)
                {
                    myDouble[i] = doubElements[i];
                }
                return new Vector(myDouble);
            }
            else
            {
                for (int i = 0; i<doubElements.length; i++)
                {
                    myDouble[i] = doubElements[i];
                }
                double myNewDouble[] = myDouble;
                for (int a = myNewDouble.length-1; a>doubElements.length-1; a--)
                {
                    myNewDouble[a] = -1;
                }

                return new Vector(myNewDouble);
            }
        }
        catch (NegativeArraySizeException e)
        {
            return new Vector(doubElements);
        }
    }

    public Vector add(Vector _v)
    {
        Vector v = new Vector(doubElements); // current vector
        double myDouble[] = new double[doubElements.length];

        if (_v.doubElements.length < v.doubElements.length)
        {
            Vector resiZed = _v.reSize(v.getVectorSize());
            double myArray[] = new double[resiZed.getVectorSize()];
            for (int a = 0; a<myArray.length; a++)
            {
                myArray[a] = v.getElementatIndex(a) + _v.getElementatIndex(a);
            }
            return new Vector(myArray);
        }
        if (_v.doubElements.length > v.doubElements.length)
        {
            Vector resiZed = v.reSize(_v.getVectorSize());
            double myArray[] = new double[resiZed.getVectorSize()];
            for (int a = 0; a<myArray.length; a++)
            {
                myArray[a] = v.getElementatIndex(a) + _v.getElementatIndex(a);
            }
            return new Vector(myArray);
        }
        // if size is same.
        if (_v.getVectorSize() == v.getVectorSize())
        {
            for (int a = 0; a<myDouble.length; a++)
            {
                myDouble[a] = v.getElementatIndex(a) + _v.getElementatIndex(a);
            }
            return new Vector(myDouble);
        }
        return null;
    }

    public Vector subtraction(Vector _v) {
        Vector v = new Vector(doubElements); // current vector
        double myDouble[] = new double[doubElements.length];
        if (_v.doubElements.length < v.doubElements.length)
        {
            Vector resiZed = _v.reSize(v.getVectorSize());
            double myArray[] = new double[resiZed.getVectorSize()];
            for (int a = 0; a<myArray.length; a++)
            {
                myArray[a] = v.getElementatIndex(a) - _v.getElementatIndex(a);
            }
            return new Vector(myArray);
        }
        if (_v.doubElements.length > v.doubElements.length)
        {
            Vector resiZed = v.reSize(_v.getVectorSize());
            double myArray[] = new double[resiZed.getVectorSize()];
            for (int a = 0; a<myArray.length; a++)
            {
                myArray[a] = v.getElementatIndex(a) - _v.getElementatIndex(a);
            }
            return new Vector(myArray);
        }
        // if size is same.
        if (_v.getVectorSize() == v.getVectorSize())
        {
            for (int a = 0; a<myDouble.length; a++)
            {
                myDouble[a] = v.getElementatIndex(a) - _v.getElementatIndex(a);
            }
            return new Vector(myDouble);
        }
        return null;
    }

    public double dotProduct(Vector _v) {
        Vector v = new Vector(doubElements); // current vector
        double myDouble[] = new double[doubElements.length];
        double sum = 0;
        if (_v.getVectorSize() == v.getVectorSize())
        {
            for (int a = 0; a<v.doubElements.length; a=a+1)
            {
                sum = sum + (v.getElementatIndex(a) * _v.getElementatIndex(a));
            }
            return sum;
        }
        if (_v.getVectorSize() > v.getVectorSize())
        {
            Vector resiZed = v.reSize(_v.getVectorSize());
            for (int a = 0; a<resiZed.doubElements.length; a=a+1)
            {
                sum = sum + (resiZed.getElementatIndex(a) * _v.getElementatIndex(a));
            }
            return sum;
        }
        if (_v.getVectorSize() < v.getVectorSize())
        {
            Vector resiZed = _v.reSize(v.getVectorSize());
            for (int a = 0; a<v.getVectorSize(); a++)
            {
                sum = sum + (resiZed.getElementatIndex(a) * v.getElementatIndex(a));
            }
            return sum;
        }
        return 0;
    }

    public double cosineSimilarity(Vector _v) {
        Vector v = new Vector(doubElements);
        if (_v.getVectorSize() == v.getVectorSize())
        {
            double sumSquaredOfV = 0;
            double sumSquarefOf_V = 0;
            for (int a = 0; a<v.getVectorSize(); a++)
            {
                double getIndexElement = v.getElementatIndex(a);
                sumSquaredOfV = sumSquaredOfV + getIndexElement*getIndexElement;
            }
            for (int a = 0; a<_v.getVectorSize(); a++)
            {
                double getIndexElement = _v.getElementatIndex(a);
                sumSquarefOf_V = sumSquarefOf_V + getIndexElement*getIndexElement;
            }
            double productSquares = Math.sqrt(sumSquaredOfV) * Math.sqrt(sumSquarefOf_V);
            return (dotProduct(_v) / productSquares);
        }
        if (_v.getVectorSize() > v.getVectorSize())
        {
            Vector resiZed = v.reSize(_v.getVectorSize());
            double sumSquaredResized = 0;
            double sumSquarefOf_V = 0;

            for (int a = 0; a<resiZed.getVectorSize(); a++)
            {
                double getIndexElement = resiZed.getElementatIndex(a);
                sumSquaredResized = sumSquaredResized + getIndexElement*getIndexElement;
            }
            for (int a = 0; a<_v.getVectorSize(); a++)
            {
                double getIndexElement = _v.getElementatIndex(a);
                sumSquarefOf_V = sumSquarefOf_V + getIndexElement*getIndexElement;
            }
            double productSquares = Math.sqrt(sumSquaredResized) * Math.sqrt(sumSquarefOf_V);
            return dotProduct(_v) / productSquares;
        }
        if (_v.getVectorSize() < v.getVectorSize())
        {
            Vector resiZed = _v.reSize(v.getVectorSize());
            double sumSquaredResized = 0;
            double sumSquarefOf_V = 0;
            for (int a = 0; a<resiZed.getVectorSize(); a++)
            {
                double getIndexElement = resiZed.getElementatIndex(a);
                sumSquaredResized = sumSquaredResized + getIndexElement*getIndexElement;
            }
            for (int a = 0; a<v.getVectorSize(); a++)
            {
                double getIndexElement = v.getElementatIndex(a);
                sumSquarefOf_V = sumSquarefOf_V + getIndexElement*getIndexElement;
            }
            double productSquares = Math.sqrt(sumSquaredResized) * Math.sqrt(sumSquarefOf_V);
            return dotProduct(_v) / productSquares;
        }

        return 0;
    }

    @Override
    public boolean equals(Object _obj) // returns true if size is the same.
    {
        Vector v = (Vector) _obj;
        if (v.getVectorSize() == ((Vector) _obj).getVectorSize())
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder mySB = new StringBuilder();
        for (int i = 0; i < this.getVectorSize(); i++) {
            mySB.append(String.format("%.5f", doubElements[i])).append(",");
        }
        mySB.delete(mySB.length() - 1, mySB.length());
        return mySB.toString();
    }
}
