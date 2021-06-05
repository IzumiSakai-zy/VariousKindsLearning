## git高阶命令指南

### 默认合并原则

* `git config --global pull.rebase false` 会设置默认的pull原则为有冲突，总之此Mac下默认的合并原则是暴力合并。如在`zhengyi-izumi-dev`下执行`git pull https://github.com/IzumiSakai-zy/VariousKindsLearning.git master `会暴力合并。这是很不可取的，因此设置成pull时默认有冲突

### 合并别人的pull request

* `git branch zhengyi-izumi-dev`：在master下执行此指令，创建一个分支，分支名已经表示了是处理那里的pull request
* `git checkout zhengyi-izumi-dev`：切换分支为zhengyi-izumi-dev
* `git pull https://github/zhengyi-izumi/VariousKindsLearning.git dev` 一定注意拉的代码分支，有时不一定都是master。此时一定会有冲突，下面进行冲突合并
* `vim Bytedance.md`  
* `git add Bytedance.md`
* `git commit -m"解决冲突"` 注意解决冲突时commit不用加文件的名字
* `git checkout master` 切换到mater，**由于之间没有对master进行过操作**，因此master的内容还是之前的，**本地暂存区是不会进行共享的**一定牢记
* `git merge zhengyi-izumi-dev` 合并之前解决了冲突的分支。此时一般都是`fast forward`无冲突，由于之间已经有commit信息了，因此此处是不用写commit信息的
* `git push -u origin master` 完成pull request

### 申请 pull request

* 首先在项目处点击fork
* 然后clone项目`https://github.com/zhengyi-izumi/VariousKindsLearning.git`到本地，然后修改提交到上面这个地址
* 然后点击原主人地址`https://github.com/IzumiSakai-zy/VariousKindsLearning`，就有pull request提示了

### git push origin master : master解析

* `orgigin` 是一个url地址，可以通过`git remote -v`进行查看
* `master ：master`左边的master是本地分支名，右边的master是远程分支名，两者一样可以只写一个
