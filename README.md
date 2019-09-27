# DesignMode
Android 设计模式

一、适配器模式简介

适配器模式（Adapter）：将一个类的接口转换成客户希望的另外一个接口。Adapter 模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

适用场景：

1、已经存在的类的接口不符合我们的需求；
2、创建一个可以复用的类，使得该类可以与其他不相关的类或不可预见的类（即那些接口可能不一定兼容的类）协同工作；
3、在不对每一个都进行子类化以匹配它们的接口的情况下，使用一些已经存在的子类。

其实现方式主要有两种：

1.类的适配器模式（采用继承实现）

2.对象适配器（采用对象组合方式实现）


二、命令模式:对命令的封装。

命令模式的主要优点如下：

(1) 降低系统的耦合度。
    由于请求者与接收者之间不存在直接引用，因此请求者与接收者之间实现完全解耦，相同的请求者可以对应不同的接收者，同样，相同的
接收者也可以供不同的请求者使用，两者之间具有良好的独立性。

(2) 新的命令可以很容易地加入到系统中。
    由于增加新的具体命令类不会影响到其他类，因此增加新的具体命令类很容易，无须修改原有系统源代码，甚至客户类代码，满足“开闭原则”的要求。

(3) 可以比较容易地设计一个命令队列或宏命令（组合命令）。

(4) 为请求的撤销(Undo)和恢复(Redo)操作提供了一种设计和实现方案。
