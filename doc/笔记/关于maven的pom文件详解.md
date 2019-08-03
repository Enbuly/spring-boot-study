<project>
  <modelVersion>4.0.0</modelVersion>
  <!--maven2.0必须是这样写，现在是maven2唯一支持的版本-->
  <!-- 基础设置 -->
  <groupId>...</groupId>
  <artifactId>...</artifactId>
  <version>...</version>
  
  packaging:打包机制，如pom,jar,maven-plugin,ejb,war,ear,rar,par
  <packaging>...</packaging>

  用户描述项目的名称，无关紧要的东西，可选
  <name>...</name>

  应该是只是写明开发团队的网站，无关紧要，可选
  <url>...</url>
  
  依赖关系
  <dependencies>...</dependencies>
  
  <parent>...</parent>
  
  <dependencyManagement>...</dependencyManagement>
  
  模块的描述
  <modules>...</modules>
  
  <properties>...</properties>

  <!--构建设置 -->
  <build>...</build>
  <reporting>...</reporting>

  <!-- 更多项目信息 -->
  <name>...</name>
  <description>...</description>
  <url>...</url>
  <inceptionYear>...</inceptionYear>
  <licenses>...</licenses>
  <organization>...</organization>
  <developers>...</developers>
  <contributors>...</contributors>

  <!-- 环境设置-->
  <issueManagement>...</issueManagement>
  <ciManagement>...</ciManagement>
  <mailingLists>...</mailingLists> 
  <scm>...</scm>
  <prerequisites>...</prerequisites>
  <repositories>...</repositories>
  <pluginRepositories>...</pluginRepositories>
  <distributionManagement>...</distributionManagement>
  <profiles>...</profiles>
</project>