use strict;
use warnings;

#!/usr/bin/perl

#有无括号一样
print "Hello, World\n";
print("Hello, world\n");

#这一行是perl中的注释

=pod 注释
这是一个多行注释
这是一样多行注释
=cut

#perl不会关心有多少个空白，双引号内空格照常打印
print       "Hello,  h
                        world\n";

#单引号和双引号,注意\n的区别
#双引号可以正常解析一些转义字符与变量，而单引号无法解析会原样输出。
print 'Hello, world\n';
print "Hello, world\n";

$a = 10;
print "a = $a\n";
print 'a = $a\n';

#Perl标识符，变量名、常量名、函数名、语句块名
#英文字母或下划线开头的 英文字母、数字、下划线，区分大小写
#$runoob
#$Runoob

#Perl数据类型：标量、数组、哈希
#标量：数字、字符串、浮点数。名字前面加上一个$
my $myfirst=123;
my $mysecond="123";
#数组。@开头
my @arr=(1,2,3);
#哈希.%开头
my %h=('a'=>1, 'b'=>2);
print "\$h{'a'} = $h{'a'}\n";



