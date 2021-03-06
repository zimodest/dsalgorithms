实现学习到的数据结构与算法

tree
BinarySearchTree 二叉搜索树
定义
二叉查找树(Binary Search Tree)，又名：二叉搜索树，二叉排序树，
    它或者是一棵空树，或者是具有下列性质的二叉树： 
    若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 
    若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
    它的左、右子树也分别为二叉排序树
算法实现
    搜索
        若b是空树，则搜索失败，否则：
        若x等于b的根结点的数据域之值，则查找成功；否则：
        若x小于b的根结点的数据域之值，则搜索左子树；否则：
        查找右子树。
    插入
        向一个二叉排序树b中插入一个结点s的算法，过程为：
        若b是空树，则将s所指结点作为根结点插入，否则：
        若s->data等于b的根结点的数据域之值，则返回，否则：
        若s->data小于b的根结点的数据域之值，则把s所指结点插入到左子树中，否则：
        把s所指结点插入到右子树中
    删除
        在二叉排序树删去一个结点，分三种情况讨论：
        若p结点为叶子结点，即PL(左子树)和PR(右子树)均为空树。由于删去叶子结点不破坏整棵树的结构，则只需修改其双亲结点的指针即可。
        若p结点只有左子树PL或右子树PR，此时只要令PL或PR直接成为其双亲结点f的左子树或右子树即可，作此修改也不破坏二叉排序树的特性。
        若p结点的左子树和右子树均不空。在删去p之后，为保持其它元素之间的相对位置不变，可按中序遍历保持有序进行调整，可以有两种做法：
            其一是令p的左子树为f的左子树，s为f左子树的最右下的结点，p的右子树为s的右子树；
            其二是令p前驱（或直接后继）替代p，然后再从二叉排序树中删去它的直接前驱（或直接后继）的直接

MyPrint.LevelOrder  层序遍历         
层序遍历的思路是，创建一个队列，先将根节点（A）入队，然后用front指针将根节点记下来，再将根节点出队，接下来看front节点（也就是刚才的根节点）有没有左孩子或右孩子，
如果有，先左（B）后右（C）入队，最后输出front节点的值，只要队列还不为空，就说明还没有遍历完，就进行下一次循环，
这时的队头元素（front）则为刚才入队的左孩子（B），然后front出队，再把它的左右孩子拉进来（如果有），因为队列的先进先出性质，B的左右孩子DE是排在C后面的，然后输出B，
下一次循环将会拉人C的左右孩子FG，最后因为FG没有左右孩子，一直出队，没有入队元素，队列迟早会变为空，当队列为空时，整颗树就层序遍历完成了，结束循环
