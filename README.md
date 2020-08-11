# DB-HR Management Program

오라클 DB와 JAVA를 이용해서 제작한 HR인사관리 프로그램 입니다
<br>


#### 기획 의도

인사 정책은 직원들이 자신들의 역량을 최대한 발휘하여 최고의 성과를 창출할 수 있도록 지원하는 역할이기 때문에 직원 한사람 한사람에 대한 데이터화와 더불어 그 데이터를 보다 효율적으로 관리할 수 있는 프로그램이 무엇보다도 중요하다고 생각했습니다.

따라서 이러한 기획의도를 바탕으로 만든 HR인사관리 프로그램은 인사팀의 효율적인 업무에 초점을 두고 제작된 프로그램입니다. 다양한 데이터의 조회와 입력을 간결하면서도 한눈에 볼 수 있도록 철저히 인사팀의 입장에서 제작된 프로그램이라고 할 수 있겠습니다.
<br>
<br>


#### 사이트맵

사이트맵은 크게 직원관리, 부서관리, 기타관리, 급여관리 4가지로 나눴으며 모든 데이터는 다양한 조건의 검색이 가능하도록 구현했습니다. 

![사이트맵](https://github.com/baekseoui/DB-HRManagementProgram/blob/master/img/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C8.jpg?raw=true)
<br>
<br>
<br>


# 기능 설명

##### Select

해당 프로그램은 인사관리 프로그램이므로 직원에 대한 관리가 간편해야 합니다.
따라서 Employees를 제외한 나머지 테이블에 대해서는 전체 검색(select * )만 가능하도록 구현했습니다.
그러나 사용자의 요구에 따라 여러가지의 검색이 가능하도록 프로그램 내에서 환경을 수정하는 것이 가능합니다.

![](https://github.com/baekseoui/DB-HRManagementProgram/blob/master/img/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C9.JPG?raw=true)
<br>
<br>



##### Update

업데이트 기능의 특징은 직급 변경, 즉 승진 시 사원 id를 입력받아 job_id 변경이 가능하다는 점입니다.
해당 사원이 진급되면 변경되는 해당 직급의 급여 범위를 평균값으로 계산하여 자동으로 salary가 적용되게 구현했습니다.

![](https://github.com/baekseoui/DB-HRManagementProgram/blob/master/img/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C11.JPG?raw=true)
<br>
<br>



##### Insert

연결되어 있는 DB값에 외래키가 있을경우 입력하기 전에 먼저 출력하고 입력할 수 있도록 구현했습니다.
직원 추가, 지점추가, 국가추가, 대륙추가, 직무추가, 부서추가가 가능하며 countries 테이블의 region_id와 locations 테이블의 country_id를 직접 입력 할 수 있도록 구현 한 이유는
switch문으로 구현할 시 추후 데이터 값을 추가 하는데 어려움이 있어 사용자 입력을 받아 직접 입력하는 방식으로 구현했습니다.

![](https://github.com/baekseoui/DB-HRManagementProgram/blob/master/img/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C12.JPG?raw=true)
<br>
<br>



##### Delete

Delete는 단어 그대로 어떠한 특정 값을 지워야 합니다.  특히 Delet의 가장 중요한 기능은 퇴사자를 처리하는 것인데요.
해당 프로그램을 계획하며 퇴사자 처리의 경우 데이터를 완전히 삭제하는 방식으로 가닥을 잡고 진행했었습니다. 하지만 데이터의 완전한 삭제 보다는 차후 퇴사자의 데이터도 이용 가능할 수 있다는 조언에 따라 퇴사의 영문 표현인 레저그네이션의 약자 RG로 job_id를 변경하는 방식을 채택하였습니다.

 전체 직원 조회시 퇴사자의 Job-id는 RG로 표시되어 출력에 포함됩니다.

![](https://github.com/baekseoui/DB-HRManagementProgram/blob/master/img/%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%93%9C13.JPG?raw=true)
<br>
<br>



##### 예외처리

예외처리는 insert와 delete의 작동 범위에 들 수 있도록 2가지 기능으로 나눠 구현했습니다.
새로 추가되는 기능의 insert는 기존에 있는 정수ID와 중복 될 수 없습니다. 
따라서 중복 추가 방지에 중점을 두고 예외처리를 진행하였으며 정수 입력 부분에서는 정수만 입력 가능하도록, 실수 입력 부분에서는 실수만 입력 가능하되 소수점에 찍히는 점이 두개 이상일 경우 사용자에게 재입력 받도록 구현했습니다.
delete는 기존에 추가되어 있는 id가 삭제되어야 하기 때문에 DB에 포함되어 있는 데이터값이 맞느냐 아니냐를 확인 할 수 있도록 진행했습니다.

